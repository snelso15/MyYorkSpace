package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextArea;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Message;

import com.google.gwt.user.client.ui.TextBox;

public class MessageView extends Composite implements View{
	private ArrayList<Message> messages;
	private ArrayList<Account> friends;
	private ListBox listBox;
	private Label lblFromUser;
	private Message displayedMessage;
	private TextArea messArea;
	private Label lblFrom;
	private Label lblMessLabel;
	private Label lblTo;
	private Label lblTouser;
	private Button btnReply;
	private Button btnNewMessage;
	private Button btnSend;
	private ListBox comboBox;
	int reply = 0;
	
	public MessageView() {
		
		
		messages = new  ArrayList<Message>();
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		panel.setSize("1000px", "1000px");
		
		
		//////////////////////////////////////////////////
		MenuBar menuBar = new MenuBar(false);
		panel.add(menuBar);
		menuBar.setWidth("1000px");
		
		MenuItem mntmHome = new MenuItem("Home", false, new Command() {
		public void execute() {
		MyYorkSpaceWebApp.setView(new HomeView());
		}
		});
		menuBar.addItem(mntmHome);
		
		MenuItemSeparator separator = new MenuItemSeparator();
		menuBar.addSeparator(separator);
		
		MenuItem mntmFriends = new MenuItem("Friends", new Command() {
		public void execute() {
		MyYorkSpaceWebApp.setView(new FriendsView());
		}
		});
		menuBar.addItem(mntmFriends);
		
		MenuItemSeparator separator_1 = new MenuItemSeparator();
		menuBar.addSeparator(separator_1);
		
		MenuItem mntmMessage = new MenuItem("Message", false, new Command() {
		public void execute() {
		MyYorkSpaceWebApp.setView(new MessageView());
		}
		});
		menuBar.addItem(mntmMessage);
		
		MenuItemSeparator separator_2 = new MenuItemSeparator();
		menuBar.addSeparator(separator_2);
		
		MenuItem mntmEvents = new MenuItem("Events", false, new Command() {
		public void execute() {
		MyYorkSpaceWebApp.setView(new EventView());
		}
		});
		menuBar.addItem(mntmEvents);
		
		
		MenuItemSeparator separator_3 = new MenuItemSeparator();
		menuBar.addSeparator(separator_3);
		/////////////////////////////////////////////////////
		
		listBox = new ListBox();
		panel.add(listBox);
		listBox.setSize("270", "500");
		panel.setWidgetLeftRight(listBox, 15.0, Unit.PX, 717.0, Unit.PX);
		panel.setWidgetTopHeight(listBox, 145.0, Unit.PX, 421.3, Unit.PX);
		listBox.setVisibleItemCount(5);
		
		messArea = new TextArea();
		messArea.setVisibleLines(20);
		messArea.setVisible(false);
		panel.add(messArea);
		messArea.setSize("350", "165");
		panel.setWidgetLeftRight(messArea, 374.0, Unit.PX, 276.0, Unit.PX);
		panel.setWidgetTopHeight(messArea, 273.0, Unit.PX, 165.0, Unit.PX);
		
		lblMessLabel = new Label("Message:");
		lblMessLabel.setVisible(false);
		panel.add(lblMessLabel);
		panel.setWidgetLeftWidth(lblMessLabel, 346.0, Unit.PX, 56.0, Unit.PX);
		panel.setWidgetTopHeight(lblMessLabel, 226.0, Unit.PX, 18.0, Unit.PX);
		
		lblFromUser = new Label("FromUser");
		lblFromUser.setVisible(false);
		panel.add(lblFromUser);
		panel.setWidgetLeftWidth(lblFromUser, 374.0, Unit.PX, 56.0, Unit.PX);
		panel.setWidgetTopHeight(lblFromUser, 171.0, Unit.PX, 18.0, Unit.PX);
		
		lblFrom = new Label("From:");
		lblFrom.setVisible(false);
		panel.add(lblFrom);
		panel.setWidgetLeftWidth(lblFrom, 346.0, Unit.PX, 56.0, Unit.PX);
		panel.setWidgetTopHeight(lblFrom, 145.0, Unit.PX, 18.0, Unit.PX);
		
		lblTo = new Label("To:");
		lblTo.setVisible(false);
		panel.add(lblTo);
		panel.setWidgetLeftWidth(lblTo, 518.0, Unit.PX, 56.0, Unit.PX);
		panel.setWidgetTopHeight(lblTo, 145.0, Unit.PX, 18.0, Unit.PX);
		
		lblTouser = new Label("ToUser");
		lblTouser.setVisible(false);
		panel.add(lblTouser);
		panel.setWidgetLeftWidth(lblTouser, 539.0, Unit.PX, 56.0, Unit.PX);
		panel.setWidgetTopHeight(lblTouser, 171.0, Unit.PX, 18.0, Unit.PX);
		
		btnReply = new Button("Reply");
		btnReply.setVisible(false);
		panel.add(btnReply);
		panel.setWidgetLeftWidth(btnReply, 276.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(btnReply, 91.0, Unit.PX, 30.0, Unit.PX);
		
		btnNewMessage = new Button("New Message");
		panel.add(btnNewMessage);
		panel.setWidgetLeftWidth(btnNewMessage, 163.0, Unit.PX, 107.0, Unit.PX);
		panel.setWidgetTopHeight(btnNewMessage, 91.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblMessages = new Label("Messages");
		panel.add(lblMessages);
		panel.setWidgetLeftWidth(lblMessages, 10.0, Unit.PX, 69.0, Unit.PX);
		panel.setWidgetTopHeight(lblMessages, 108.0, Unit.PX, 18.0, Unit.PX);
		
		btnSend = new Button("Send");
		btnSend.setVisible(false);
		panel.add(btnSend);
		panel.setWidgetLeftWidth(btnSend, 623.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(btnSend, 469.0, Unit.PX, 30.0, Unit.PX);
		
		comboBox = new ListBox();
		panel.add(comboBox);
		comboBox.setVisible(false);
		panel.setWidgetLeftWidth(comboBox, 528.0, Unit.PX, 133.0, Unit.PX);
		panel.setWidgetTopHeight(comboBox, 171.0, Unit.PX, 26.0, Unit.PX);
		
		
		
	}

	private void getMessages(String userName) {
		RPC.MessageService.getMessages(userName, new AsyncCallback<ArrayList<Message>>() {
			@Override
			public void onSuccess(ArrayList<Message> returnedList) {
				if (returnedList == null) {
					GWT.log("no messages returned");
				} else {
					// Successful
					messages = returnedList;
					GetFriends(Session.getInstance().getAccount());
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				// TODO: display error msg
				GWT.log("message RPC call failed", caught);
			}
		});
	}
	
	private void addMessage(String fromUser, String toUser, String messText)
	{
		RPC.MessageService.addMessage(fromUser, toUser, messText, new AsyncCallback<Message>() {
			@Override
			public void onSuccess(Message returnedMessage){
				if(returnedMessage==null){
					
				}
				else {
					MyYorkSpaceWebApp.setView(new MessageView());
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("add message RPC call failed", caught);
			}
		});
	}
	
	protected void GetFriends(Account host) {
		RPC.FriendsService.getFriends(host.getEmail(), new AsyncCallback<ArrayList<Account>>() {
			@Override
			public void onSuccess(ArrayList<Account> returnedList) {
				if (returnedList == null) {
					GWT.log("Host Account no longer exists");
					
				} else {
					// Successful
					friends = returnedList;
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
		comboBox.setVisibleItemCount(friends.size());
		for(int i = 0; i < friends.size(); i++)
		{
			comboBox.addItem(friends.get(i).getUserName());
		}
		listBox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				lblFrom.setVisible(true);
				messArea.setVisible(true);
				messArea.setReadOnly(true);
				lblMessLabel.setVisible(true);
				lblFromUser.setVisible(true);
				lblTo.setVisible(true);
				lblTouser.setVisible(true);
				btnReply.setVisible(true);
				btnSend.setVisible(false);
				comboBox.setVisible(false);
				displayedMessage =  messages.get(listBox.getSelectedIndex());
				lblFromUser.setText(displayedMessage.getFromUser());
				lblTouser.setText(displayedMessage.getToUser());
				messArea.setText(displayedMessage.getMessText());
			}
		});
		
		btnReply.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				lblTouser.setText(displayedMessage.getFromUser());
				lblFrom.setVisible(false);
				messArea.setVisible(true);
				messArea.setText("");
				messArea.setReadOnly(false);
				lblMessLabel.setVisible(true);
				lblFromUser.setVisible(false);
				lblTo.setVisible(true);
				lblTouser.setVisible(true);
				btnReply.setVisible(false);
				btnSend.setVisible(true);
				comboBox.setVisible(false);
				reply = 1;
			}
		});
		
		btnNewMessage.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				lblFrom.setVisible(false);
				messArea.setVisible(true);
				messArea.setText("");
				messArea.setReadOnly(false);
				lblMessLabel.setVisible(true);
				lblFromUser.setVisible(false);
				lblTo.setVisible(true);
				lblTouser.setVisible(false);
				btnReply.setVisible(false);
				btnSend.setVisible(true);
				comboBox.setVisible(true);
				reply = 0;
				
			}
		});
		
		btnSend.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				/*lblFrom.setVisible(false);
				messArea.setVisible(true);
				messArea.setText("");
				messArea.setReadOnly(false);
				lblMessLabel.setVisible(true);
				lblFromUser.setVisible(false);
				lblTo.setVisible(true);
				lblTouser.setVisible(false);
				btnReply.setVisible(false);
				btnSend.setVisible(true);
				textBox.setVisible(true);
				comboBox.setVisible(false);*/
				
				if(messArea.getText() != null)
				{
					if(reply == 0)
					{
						addMessage(Session.getInstance().getAccount().getUserName(), friends.get(comboBox.getSelectedIndex()).getUserName(), messArea.getText());
					}
					else
					{
						addMessage(Session.getInstance().getAccount().getUserName(), lblTouser.getText(), messArea.getText());
					}
					
				}
				
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
