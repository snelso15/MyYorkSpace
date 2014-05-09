package edu.ycp.cs320.myYorkSpace.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.myYorkSpace.client.ProfileService;
import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Post;

public class ProfileServiceImpl extends RemoteServiceServlet implements ProfileService{

	@Override
	public ArrayList<Post> getActiveUserPosts(Account user)
	{	
		return user.getPosts();
	}
	public String getUserName(Account user)
	{
		return user.getUserName();
	}
	@Override
	public Account addPostToUser(Account userProfileBeingShown, String fromUser, String text) {
		SiteController controller = new SiteController();
		return controller.addPostToUser(userProfileBeingShown, fromUser, text);

	}
}
