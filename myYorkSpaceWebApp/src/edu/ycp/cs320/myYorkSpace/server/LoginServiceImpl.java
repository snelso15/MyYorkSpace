package edu.ycp.cs320.myYorkSpace.server;

import edu.ycp.cs320.myYorkSpace.client.LoginService;
import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Account;

public class LoginServiceImpl implements LoginService {

	@Override
	public Account logIn(String email, String password) {
		SiteController controller = new SiteController();
		
		return controller.logIn(email, password);
	}

}
