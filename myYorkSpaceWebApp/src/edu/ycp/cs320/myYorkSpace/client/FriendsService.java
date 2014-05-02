package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Account;

@RemoteServiceRelativePath("friends")
public interface FriendsService extends RemoteService {
	public ArrayList<Account> getFriends(String email);
}
 