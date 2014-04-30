package edu.ycp.cs320.myYorkSpace.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Account;


@RemoteServiceRelativePath("friends")
public interface FriendsServiceAsync {
	public void getFriends(String email, AsyncCallback<List <Account>> callback);
}
