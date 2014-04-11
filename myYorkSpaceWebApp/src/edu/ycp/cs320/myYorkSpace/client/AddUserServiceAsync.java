package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.myYorkSpace.shared.Account;

public interface AddUserServiceAsync {
	void AddUser(Account accountToAdd, AsyncCallback<Account> asyncCallback);
}
