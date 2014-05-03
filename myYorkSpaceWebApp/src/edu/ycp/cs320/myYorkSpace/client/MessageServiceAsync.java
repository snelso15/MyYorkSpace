package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.myYorkSpace.shared.Message;

@RemoteServiceRelativePath("message")
public interface MessageServiceAsync {

	public void getMessages(String user, AsyncCallback<ArrayList<Message>> asyncCallback);
	//public void addMessage(String fromUser, String toUser, String messText, AsyncCallback<Message> asyncCallback);
}
