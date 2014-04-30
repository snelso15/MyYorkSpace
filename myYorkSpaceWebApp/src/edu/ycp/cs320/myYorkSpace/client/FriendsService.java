package edu.ycp.cs320.myYorkSpace.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Event;

@RemoteServiceRelativePath("friends")
public interface FriendsService extends RemoteService {
	public List<Account> getFriends(String email);
}
 