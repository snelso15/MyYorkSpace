package edu.ycp.cs320.myYorkSpace.client;

import edu.ycp.cs320.myYorkSpace.shared.Account;

public class Session {
	private static final Session theInstance = new Session();
	
	public static Session getInstance() {
		return theInstance;
	}
	
	private Account account;
	
	public Session() {
		
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
	
}
