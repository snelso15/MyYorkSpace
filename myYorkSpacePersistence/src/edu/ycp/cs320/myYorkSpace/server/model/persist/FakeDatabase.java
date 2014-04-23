package edu.ycp.cs320.myYorkSpace.server.model.persist;

import java.util.ArrayList;
import java.util.List;




import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Attachment;
import edu.ycp.cs320.myYorkSpace.shared.Birthday;
import edu.ycp.cs320.myYorkSpace.shared.Event;
import edu.ycp.cs320.myYorkSpace.shared.Message;
import edu.ycp.cs320.myYorkSpace.shared.Post;

public class FakeDatabase implements IDatabase {
	private List<Account> accountList;
	private List<Post> postList;
	private List<Message> messageList;
	private List<Event> eventList;
	
	public FakeDatabase() {

		Account account= new Account();
		account.setEmail("sam@ycp.edu");
		Birthday birthday = new Birthday(5, 7, 1994);
		account.setBirthDate(birthday.toString());
		account.setMajor("Computer Engineering");
		account.setPassword("123abc");
		account.setUserName("Sam");
		
		accountList = new ArrayList<Account>();
		accountList.add(account);

		account.setEmail("alec@ycp.edu");
		Birthday birthday1 = new Birthday(12, 7, 1993);
		account.setBirthDate(birthday1.toString());
		account.setMajor("Electrical Engineering");
		account.setPassword("abc123");
		account.setUserName("Alec");
	
		accountList.add(account);
		
		account.setEmail("prof@ycp.edu");
		Birthday birthday2 = new Birthday(11, 5, 1975);
		account.setBirthDate(birthday2.toString());
		account.setMajor("Mechanical Engineering");
		account.setPassword("1a2b3c");
		account.setUserName("Prof");
		
		accountList.add(account);
		
		eventList = new ArrayList<Event>();
		// TODO: populate
	}
	public void addUser(Account userToAdd){
			accountList.add(userToAdd);
	}
	
	
	public Account logIn(String email, String password) {
		Account thisUser = findUserByEmail(email);
		if(thisUser==null){
			System.out.println("Account with this Email does not exist");
			return null;
		}
		if (thisUser.getPassword().equals(password)) {
			return thisUser;
		}
		return null;
	}
	
	public Account findUserByUserName(String name) {
		for (Account acct : accountList) {
			if (acct.getUserName().equals(name)) {
				return acct;
			}
		}
		return null;
	}
	
	public Account findUserByEmail(String email) {
		for (Account acct : accountList) {
			if (acct.getEmail().equals(email)) {
				return acct;
			}
		}
		return null;
	}
	
	public void createPost(Post postToAdd) {
		postList.add(postToAdd);
		
	}
	
	public ArrayList<Post> getPosts(String postUser) {
		ArrayList<Post> foundPosts = new ArrayList<Post>();
		for(Post post : postList)
		{
			if(post.getPostUser().equals(postUser))
			{
				foundPosts.add(post);
			}
		}
		return foundPosts;
	}
	public void createMessage(Message messToAdd) {
		messageList.add(messToAdd);
		
	}
	
	public ArrayList<Message> getMessage(String user) {
		ArrayList<Message> foundMess = new ArrayList<Message>();
		for(Message mess : messageList)
		{
			if(mess.getToUser().equals(user))
			{
				foundMess.add(mess);
			}
		}
		return foundMess;
	}
}
