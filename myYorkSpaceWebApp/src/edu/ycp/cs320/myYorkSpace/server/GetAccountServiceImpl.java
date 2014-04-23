package edu.ycp.cs320.myYorkSpace.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.myYorkSpace.client.GetAccountService;
import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Account;


public class GetAccountServiceImpl extends RemoteServiceServlet implements GetAccountService {
	@Override
	public Account getAccount(String email) {
		SiteController controller = new SiteController();
		return controller.findUserByEmail(email);
	}

}
 