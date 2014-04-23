package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.myYorkSpace.shared.Event;

public interface EventServiceAsync {

	void getEventsForProfile(int profileId, AsyncCallback<Event[]> callback);

}
