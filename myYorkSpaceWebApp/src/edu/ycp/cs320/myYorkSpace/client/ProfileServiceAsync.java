package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Post;

public interface ProfileServiceAsync {
	
	void getFriendPosts(Account user, AsyncCallback<ArrayList<Post>> callback);
}
