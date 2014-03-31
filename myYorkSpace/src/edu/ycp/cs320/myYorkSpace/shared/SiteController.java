package edu.ycp.cs320.myYorkSpace.shared;

import java.util.ArrayList;

public class SiteController {
	//returns the 
	public Account logIn(String email, String password, Site site){
		Account userLoggingIn = findUserByEmail(email, site);
		if(userLoggingIn.getPassword() == password){
			
		}
	}
	//returns an account object if the account's email matches the one given
	public Account findUserByEmail(String email, Site site){
		ArrayList<Account> users = site.getUsers();
		for(int i=0; i<users.size(); i++){
			Account thisUser = users.get(i);
			if(thisUser.getEmail() == email){
				return thisUser;
			}
		}
		return null;
	}
}
