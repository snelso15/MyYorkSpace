package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Account;

@RemoteServiceRelativePath("AddUser")
public interface AddUserService extends RemoteService {
	public Account AddUser(Account account);
}
