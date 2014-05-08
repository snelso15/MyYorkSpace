package edu.ycp.cs320.myYorkSpace.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.myYorkSpace.client.EventService;
import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Event;

public class EventServiceImpl extends RemoteServiceServlet implements
		EventService {

	@Override
	public ArrayList<Event> getEvents(String email){
		SiteController controller = new SiteController();
		return controller.getEventsForUser(email);
	}
	@Override
	public Event addEvent(String name, String description, String time){
		SiteController controller = new SiteController();
		return controller.addEvent(name, description, time, null );
	}

}
   