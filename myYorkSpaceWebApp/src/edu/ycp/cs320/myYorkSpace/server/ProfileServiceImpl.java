package edu.ycp.cs320.myYorkSpace.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.myYorkSpace.client.ProfileService;
import edu.ycp.cs320.myYorkSpace.server.controllers.PostController;
import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Post;

public class ProfileServiceImpl extends RemoteServiceServlet implements ProfileService{

	@Override
	public ArrayList<Post> getFriendPosts(Account user)
	{
		PostController controller = new PostController();
		ArrayList<Account> friends = new ArrayList<Account>();
		//find user friends
		friends = user.getFriends();
		//Get active user's username
		String activeUser = user.getUserName();
		//find posts made by friends as well as made by user
		
		for(int i = 0; i < friends.size(); i++)
		{
			String curFriend = friends[i].getUserName();
			for(int j = 0; j < controller.getPost(curFriend).size(); j++)
			{
				
			}
			
			
		}
		
		//return array list
		return 
	}
	
}
