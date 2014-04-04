package edu.ycp.cs320.myYorkSpace.server.model.persist;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.booksdb.model.Author;
import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Birthday;

public class FakeDatabase implements IDatabase {
	private List<Account> accountList;
	
	public FakeDatabase() {
		accountList = new ArrayList<Account>();
		Account account= new Account();
		account.setEmail("sam@ycp.edu");
		Birthday birthday = new Birthday(5, 7, 1994);
		account.setBirthDate(birthday.toString());
		account.setMajor("Computer Engineering");
		account.setPassword("123abc");
		account.setUserName("Sam");
		
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
	}
	public void addUser(Account userToAdd){
		if(verifyUser(userToAdd)){
			accountList.add(userToAdd);
		}
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
	
	public boolean verifyUser(Account user){
		if(validEmail(user.getEmail())&&validPassword(user.getPassword())) return true;
		else return false;
	}
	
	public boolean validEmail(String email){
		boolean valid = false;
		if(email.contains("@")&&(email.contains(".edu"))) valid=true;
		return valid;
	}
	public boolean validPassword(String password){
		//password must be at least 5 characters long
		if(password.length()<5)return false;
		//password must be sequence of numbers between 0-9 or capitol/lower case letters.
		boolean valid = true;
		for(int i = 0; i<password.length()-1; i++){
			if(!(password.charAt(i) >= '0' && password.charAt(i) <= '9')&&!(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')&& !(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')) valid=false;
		}
		return valid; 
	}

}
