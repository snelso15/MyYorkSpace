package edu.ycp.cs320.myYorkSpace.shared;

import java.util.ArrayList;

public class Site {
	private ArrayList<Account> Users;

	public Site(ArrayList<Account> users) {
		Users = users;
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
	public boolean verifyUser(Account user){
		if(validEmail()&&validPassword()) return true;
		else return false;
	}
	public boolean validEmail(String email){
		boolean valid = false;
		//for(int i = 0; i<email.length()-1; i++){
		if(	email.contains("@")&&(email.contains(".edu"))) valid=true;
		return valid;
	}
	public boolean validEmail(String password){
		boolean valid = false;
		for(int i = 0; i<email.length()-1; i++){
		if(	email.contains("@")&&(email.contains(".edu"))) valid=true;
		return valid;
	}
	
}
