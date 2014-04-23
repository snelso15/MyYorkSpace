package edu.ycp.cs320.myYorkSpace.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.myYorkSpace.client.GetAccountService;
import edu.ycp.cs320.myYorkSpace.client.GetFriendsService;
import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Account;


public class GetFriendsServiceImpl extends RemoteServiceServlet implements GetFriendsService {
	@Override
	public ArrayList<Account> getFriends(Account account) {
		SiteController controller = new SiteController();
		return controller.findUserByEmail(account.getEmail()).getFriends();
	}

}
 