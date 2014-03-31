package edu.ycp.cs320.myYorkSpace.server.model.persist;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.myYorkSpace.shared.Account;

public class FakeDatabase implements IDatabase {
	private List<Account> accountList;
	
	public FakeDatabase() {
		accountList = new ArrayList<Account>();
		// TODO: create sample accounts
	}

	@Override
	public Account logIn(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
