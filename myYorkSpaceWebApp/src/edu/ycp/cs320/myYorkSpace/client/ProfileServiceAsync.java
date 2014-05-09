package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Post;

public interface ProfileServiceAsync {
	
	public void getActiveUserPosts(Account user, AsyncCallback<ArrayList<Post>> callback);
	public void getUserName(Account user, AsyncCallback<String> callback);
	public void addPostToUser(Account userProfileBeingShown, String userName, String text, AsyncCallback<Account> asyncCallback);
}
