package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Event;

@RemoteServiceRelativePath("event")
public interface EventService extends RemoteService {
	public Event[] getEventsForProfile(int profileId);//;events associated with each user's profile
}
