package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Event;

@RemoteServiceRelativePath("event")
public interface EventService extends RemoteService {
	public ArrayList<Event> getEvents(String email);

	public Event addEvent(String name, String description, String time);
}
 