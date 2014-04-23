package edu.ycp.cs320.myYorkSpace.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.myYorkSpace.client.AddUserService;
import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Account;

public class AddUserServiceImpl extends RemoteServiceServlet implements AddUserService {

	@Override
	public Account AddUser(Account account) {
		System.out.println("create account attempt attempt: email=" + account.getEmail() + ", password=" + account.getPassword() + "Birthday=" + account.getBirthDate());
		SiteController controller = new SiteController();

		return controller.addUser(account);
	}
}
 