package edu.ycp.cs320.myYorkSpace.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.myYorkSpace.client.LoginService;
import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Account;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	@Override
	public Account logIn(String email, String password) {
		System.out.println("Login attempt: email=" + email + ", password=" + password);
		SiteController controller = new SiteController();
		
		return controller.logIn(email, password);
	}

}
