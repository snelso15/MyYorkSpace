package edu.ycp.cs320.myYorkSpace.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.myYorkSpace.client.EventService;
import edu.ycp.cs320.myYorkSpace.shared.Event;

public class EventServiceImpl extends RemoteServiceServlet implements
		EventService {

	@Override
	public Event[] getEventsForProfile(int profileId) {
		// TODO Auto-generated method stub
		return null;
	}

}
