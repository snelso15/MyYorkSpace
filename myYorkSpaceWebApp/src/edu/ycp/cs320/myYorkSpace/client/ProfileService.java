package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Post;


@RemoteServiceRelativePath("profile")
public interface ProfileService extends RemoteService{

	public ArrayList<Post> getFriendPosts(Account user);
}
