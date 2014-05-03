package edu.ycp.cs320.myYorkSpace.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.myYorkSpace.client.FriendsService;
import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Account;


public class FriendsServiceImpl extends RemoteServiceServlet implements
		FriendsService {

	@Override
	public ArrayList<Account> getFriends(String email){
		SiteController controller = new SiteController();
		return controller.getFriendsOfUser(email);
	}
	
	@Override
	public ArrayList<Account> getUsersToAdd(String email) {
		SiteController controller = new SiteController();
		return controller.getNonFriendsOfUser(email);
	}
	
	@Override
	public Account addUser(String email, Account newFriend){
		SiteController controller = new SiteController();
		return controller.addFriend(email, newFriend);
	}
}
 