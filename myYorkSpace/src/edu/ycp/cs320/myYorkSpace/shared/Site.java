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
	public boolean verifyUser(Account user){
		if(validEmail(user.getEmail())&&validPassword(user.getPassword())) return true;
		else return false;
	}
	public boolean validEmail(String email){
		boolean valid = false;
		if(	email.contains("@")&&(email.contains(".edu"))) valid=true;
		return valid;
	}
	public boolean validPassword(String password){
		//password must be at least 5 characters long
		if(password.length()<5)return false;
		//password must be sequence of numbers between 0-9 or capitol/lower case letters.
		boolean valid = true;
		for(int i = 0; i<password.length()-1; i++){
			if(!(password.charAt(i) >= 47 && password.charAt(i) <= 57)) valid=false;
			if(!(password.charAt(i) >= 65 && password.charAt(i) <= 90)) valid=false;
			if(!(password.charAt(i) >= 97 && password.charAt(i) <= 122)) valid=false;
		}
		return valid; 
	}
	
}
