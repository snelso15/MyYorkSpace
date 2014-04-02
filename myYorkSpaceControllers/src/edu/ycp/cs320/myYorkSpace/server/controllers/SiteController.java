package edu.ycp.cs320.myYorkSpace.server.controllers;

import java.util.ArrayList;

import edu.ycp.cs320.myYorkSpace.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Site;

public class SiteController {
	//returns the 
	public Account logIn(String email, String password){
		return DatabaseProvider.getInstance().logIn(email, password);
	}
//	public Account logIn(String email, String password, Site site){
//		Account userLoggingIn = findUserByEmail(email, site);
//		if(userLoggingIn.getPassword() == password){
//			
//		}
//	}
//	//returns an account object if the account's email matches the one given
//	public Account findUserByEmail(String email, Site site){
//		ArrayList<Account> users = site.getUsers();
//		for(int i=0; i<users.size(); i++){
//			Account thisUser = users.get(i);
//			if(thisUser.getEmail() == email){
//				return thisUser;
//			}
//		}
//		return null;
//	}
}
