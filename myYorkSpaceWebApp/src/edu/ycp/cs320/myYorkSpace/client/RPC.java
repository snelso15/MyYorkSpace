package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.core.shared.GWT;

public class RPC {
	public static final LoginServiceAsync LoginService =
			GWT.create(LoginService.class);
	public static final AddUserServiceAsync AddUserService =
			GWT.create(AddUserService.class);
	public static final GetFriendsServiceAsync GetFriendsService =
			GWT.create(GetFriendsService.class);
	public static final EventServiceAsync EventService =
			GWT.create(EventService.class);
	public static final FriendsServiceAsync FriendsService =
			GWT.create(FriendsService.class);
}
