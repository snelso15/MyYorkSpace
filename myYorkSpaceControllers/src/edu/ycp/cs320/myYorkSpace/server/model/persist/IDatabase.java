package edu.ycp.cs320.myYorkSpace.server.model.persist;

import edu.ycp.cs320.myYorkSpace.shared.Account;

public interface IDatabase {
	public Account logIn(String email, String password);
	public void addUser(Account userToAdd);
	public Account findUserByUserName(String name);
	public Account findUserByEmail(String email);
}

