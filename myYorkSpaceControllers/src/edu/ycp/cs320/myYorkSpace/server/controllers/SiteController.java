package edu.ycp.cs320.myYorkSpace.server.controllers;

import java.util.ArrayList;

import edu.ycp.cs320.myYorkSpace.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.myYorkSpace.shared.Account;

public class SiteController {
	//returns the 
	public Account logIn(String email, String password){
		return DatabaseProvider.getInstance().logIn(email, password);
	}
}
