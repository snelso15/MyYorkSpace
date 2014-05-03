package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Message;

@RemoteServiceRelativePath("message")
public interface MessageService extends RemoteService{
	
	public ArrayList<Message> getMessages(String user);
	public Message addMessage(String fromUser, String toUser, String messText);

}
