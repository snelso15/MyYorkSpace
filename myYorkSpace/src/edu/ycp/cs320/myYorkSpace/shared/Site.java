package edu.ycp.cs320.myYorkSpace.shared;

import java.util.ArrayList;

public class Site {
	private ArrayList<Account> Users;

	public Site() {
		Users = null;
	}

	public ArrayList<Account> getUsers() {
		return Users;
	}

	public void setUsers(ArrayList<Account> users) {
		Users = users;
	}
	public void addUser(Account user){
		this.Users.add(user);
	}

	
}
