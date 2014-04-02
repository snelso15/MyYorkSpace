package edu.ycp.cs320.myYorkSpace.server.model.persist;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public Account logIn(String email, String password) {
		for (Account acct : accountList) {
			if (acct.getEmail().equals(email) && acct.getPassword().equals(password)) {
				return acct;
			}
		}
		return null;
	}

}
