package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Account;

@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	public Account logIn(String email, String password);
}
