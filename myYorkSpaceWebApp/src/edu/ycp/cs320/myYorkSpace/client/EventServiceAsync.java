package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Event;


@RemoteServiceRelativePath("event")
public interface EventServiceAsync {
	public void getEvents(String email, AsyncCallback<ArrayList<Event>> asyncCallback);

	void addEvent(String name, String description, String time, AsyncCallback<Event> callback);
}
