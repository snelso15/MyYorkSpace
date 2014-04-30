package edu.ycp.cs320.myYorkSpace.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.myYorkSpace.client.EventService;
import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Event;

public class EventServiceImpl extends RemoteServiceServlet implements
		EventService {

	@Override
	public List<Event> getEvents(String email){
		SiteController controller = new SiteController();
		return controller.getEventsForUser(email);
	}

}
 