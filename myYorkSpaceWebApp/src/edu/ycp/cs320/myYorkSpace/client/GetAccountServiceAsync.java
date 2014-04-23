
package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Account;


@RemoteServiceRelativePath("getAccount")
public interface GetAccountServiceAsync{
	public void getAccount(String email, AsyncCallback<Account> callback);
}
