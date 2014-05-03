package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;



import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Account;


@RemoteServiceRelativePath("friends")
public interface FriendsServiceAsync {
	public void getFriends(String email, AsyncCallback<ArrayList <Account>> callback);

	public void getUsersToAdd(String email,
			AsyncCallback<ArrayList<Account>> asyncCallback);

	public void addUser(String email, Account newFriend,
			AsyncCallback<Account> asyncCallback);
}
