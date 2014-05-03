package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextArea;

import edu.ycp.cs320.myYorkSpace.shared.Message;

public class MessageView extends Composite implements View{
	private ArrayList<Message> messages;
	private ListBox listBox;
	private Label lblFromUser;
	private Message displayedMessage;
	private TextArea messArea;
	
	public MessageView() {
		
		
		messages = new  ArrayList<Message>();
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("811px", "692px");
		
		listBox = new ListBox();
		layoutPanel.add(listBox);
		layoutPanel.setWidgetLeftWidth(listBox, 0.0, Unit.PX, 270.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(listBox, 114.0, Unit.PX, 578.0, Unit.PX);
		listBox.setVisibleItemCount(5);
		
		Label lblMessages = new Label("Messages");
		layoutPanel.add(lblMessages);
		layoutPanel.setWidgetLeftWidth(lblMessages, 0.0, Unit.PX, 69.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblMessages, 76.0, Unit.PX, 18.0, Unit.PX);
		
		Button btnCreateMessage = new Button("Create Message");
		layoutPanel.add(btnCreateMessage);
		layoutPanel.setWidgetLeftWidth(btnCreateMessage, 629.0, Unit.PX, 119.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnCreateMessage, 625.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblFrom = new Label("From:");
		layoutPanel.add(lblFrom);
		layoutPanel.setWidgetLeftWidth(lblFrom, 346.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblFrom, 147.0, Unit.PX, 18.0, Unit.PX);
		
		Button btnNewButton = new Button("Home Button");
		btnNewButton.setText("Home");
		layoutPanel.add(btnNewButton);
		layoutPanel.setWidgetLeftWidth(btnNewButton, 0.0, Unit.PX, 81.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnNewButton, 0.0, Unit.PX, 30.0, Unit.PX);
		
		Button btnNewButton_1 = new Button("Friends button");
		btnNewButton_1.setText("Friends");
		layoutPanel.add(btnNewButton_1);
		layoutPanel.setWidgetLeftWidth(btnNewButton_1, 87.0, Unit.PX, 81.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnNewButton_1, 0.0, Unit.PX, 30.0, Unit.PX);
		
		Button btnNewButton_2 = new Button("Events button");
		btnNewButton_2.setText("Events");
		layoutPanel.add(btnNewButton_2);
		layoutPanel.setWidgetLeftWidth(btnNewButton_2, 174.0, Unit.PX, 81.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnNewButton_2, 0.0, Unit.PX, 30.0, Unit.PX);
		
		Button btnNewButton_3 = new Button("Message button");
		btnNewButton_3.setText("Messages");
		layoutPanel.add(btnNewButton_3);
		layoutPanel.setWidgetLeftWidth(btnNewButton_3, 261.0, Unit.PX, 81.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnNewButton_3, 0.0, Unit.PX, 30.0, Unit.PX);
		
		messArea = new TextArea();
		layoutPanel.add(messArea);
		layoutPanel.setWidgetLeftWidth(messArea, 374.0, Unit.PX, 350.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(messArea, 273.0, Unit.PX, 165.0, Unit.PX);
		
		Label lblNewLabel = new Label("Message:");
		layoutPanel.add(lblNewLabel);
		layoutPanel.setWidgetLeftWidth(lblNewLabel, 346.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblNewLabel, 226.0, Unit.PX, 18.0, Unit.PX);
		
		lblFromUser = new Label("FromUser");
		layoutPanel.add(lblFromUser);
		layoutPanel.setWidgetLeftWidth(lblFromUser, 374.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblFromUser, 171.0, Unit.PX, 18.0, Unit.PX);
		
		
		
		
	}

	private void getMessages(String userName) {
		RPC.MessageService.getMessages(userName, new AsyncCallback<ArrayList<Message>>() {
			@Override
			public void onSuccess(ArrayList<Message> returnedList) {
				if (returnedList == null) {
					GWT.log("Host Account no longer exists");
				} else {
					// Successful
					messages = returnedList;
					impl();
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				// TODO: display error msg
				GWT.log("Login RPC call failed", caught);
			}
		});
	}

	
	public void impl() {

		listBox.setVisibleItemCount(messages.size());
		for(int i = 0; i < messages.size(); i++)
		{
			listBox.addItem(messages.get(i).getMessText());
		}
		listBox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				
				displayedMessage =  messages.get(listBox.getSelectedIndex());
				lblFromUser.setText(displayedMessage.getFromUser());
				messArea.setText(displayedMessage.getMessText());
			}
		});
	}

	@Override
	public void activate() {
		getMessages(Session.getInstance().getAccount().getUserName());
		
	}

	@Override
	public String isA() {
		// TODO Auto-generated method stub
		return null;
	}
}
