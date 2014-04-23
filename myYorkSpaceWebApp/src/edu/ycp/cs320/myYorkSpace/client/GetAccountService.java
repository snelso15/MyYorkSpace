package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Account;


@RemoteServiceRelativePath("getAccount")
public interface GetAccountService extends RemoteService {
	public Account getAccount(String email);
}
