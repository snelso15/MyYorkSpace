package edu.ycp.cs320.myYorkSpace.server.controllers;

import edu.ycp.cs320.myYorkSpace.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.myYorkSpace.shared.Message;

public class MessageController {
	public void createMessage(String fromUser, String toUser, String messText)
	{
		Message m = new Message(fromUser, toUser, messText);
		DatabaseProvider.getInstance().createMessage(m);
	}
	
	public ArrayList<Message> getMessage(String user)
	{
		return DatabaseProvider.getInstance().getMessage(user);
	}
}
