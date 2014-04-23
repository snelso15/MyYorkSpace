package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.core.shared.GWT;

public class RPC {
	public static final LoginServiceAsync loginService =
			GWT.create(LoginService.class);
	public static final AddUserServiceAsync AddUserService =
			GWT.create(AddUserService.class);
	public static final GetAccountServiceAsync GetAccountService =
			GWT.create(GetAccountService.class);
	public static final GetFriendsServiceAsync GetFriendsService =
			GWT.create(GetFriendsService.class);
}
