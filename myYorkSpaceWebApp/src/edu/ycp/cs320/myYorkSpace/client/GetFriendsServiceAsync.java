package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Account;


@RemoteServiceRelativePath("getFriends")
public interface GetFriendsServiceAsync{
	public void getFriends(Account account, AsyncCallback<ArrayList<Account>> callback);
}
