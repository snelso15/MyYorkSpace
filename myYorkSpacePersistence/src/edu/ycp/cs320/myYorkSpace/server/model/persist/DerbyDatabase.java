package edu.ycp.cs320.myYorkSpace.server.model.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Event;
import edu.ycp.cs320.myYorkSpace.shared.Message;
import edu.ycp.cs320.myYorkSpace.shared.Post;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby JDBC driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	/*
	@Override
	public List<Account> findUserByEmail(final String title) {
		return executeTransaction(new Transaction<List<Account>>() {
			@Override
			public List<Account> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select Accounts.*, books.* " +
							"  from Accounts, books " +
							" where Accounts.id = books.Account_id " +
							"   and books.title = ?"
					);
					stmt.setString(1, title);
					
					List<Account> result = new ArrayList<Account>();
					
					resultSet = stmt.executeQuery();
					while (resultSet.next()) {
						Account Account = new Account();
						loadAccount(Account, resultSet, 1);
						Book book = new Book();
						loadBook(book, resultSet, 4);
						
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	*/
	
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:books.db;create=true");
		
		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	private void loadAccount(Account Account, ResultSet resultSet, int index) throws SQLException {
		Account.setUserName(resultSet.getString(index++));
		Account.setEmail(resultSet.getString(index++));
		Account.setPassword(resultSet.getString(index++));
	}
	

	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				
				try {
					stmt1 = conn.prepareStatement(
							"create table books (" +
							"    id integer primary key," +
							"    Account_id integer," +
							"    title varchar(50)," +
							"    isbn varchar(20)" +
							")");
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
							"create table Accounts (" +
							"    id integer primary key," +
							"    lastname varchar(40)," +
							"    firstname varchar(40)" +
							")");
					stmt2.executeUpdate();
					
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<Account> AccountList;
				
				try {
					AccountList = InitialData.getAccounts();

				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertAccount = null;

				try {
					insertAccount = conn.prepareStatement("insert into Accounts values (?, ?, ?)");
					for (Account Account : AccountList) {
						insertAccount.setString(1, Account.getEmail());
						insertAccount.setString(2, Account.getUserName());
						insertAccount.setString(3, Account.getPassword());
						insertAccount.addBatch();
					}
					insertAccount.executeBatch();
					
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertAccount);
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Success!");
	}

	@Override
	public Account logIn(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(Account userToAdd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account findUserByUserName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Message> getMessage(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPost(Post postToAdd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Post> getPosts(String postUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message addMessage(Message messToAdd, String toUser) {
		// TODO Auto-generated method stub
		return null; 
	}

	@Override
	public ArrayList<Account> getAccountList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event addEvent(Event eventToAdd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account addPostToUser(Account userProfileBeingShown, Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Event> getEventsForUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
