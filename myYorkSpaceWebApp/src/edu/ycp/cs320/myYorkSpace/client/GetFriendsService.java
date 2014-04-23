package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Account;


@RemoteServiceRelativePath("getFriends")
public interface GetFriendsService extends RemoteService {
	public ArrayList<Account> getFriends(Account account);
}
