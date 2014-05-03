package edu.ycp.cs320.myYorkSpace.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.myYorkSpace.client.MessageService;
import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Message;

public class MessageServiceImpl extends RemoteServiceServlet implements MessageService{

	@Override
	public ArrayList<Message> getMessages(String user) {
		SiteController controller = new SiteController();
		return controller.getUserMessages(user);
	}

	@Override
	public Message addMessage(String fromUser, String toUser, String messText) {
		SiteController controller = new SiteController();
		return controller.addMessage(fromUser, toUser, messText);
	}

}
