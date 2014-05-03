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

import edu.ycp.cs320.myYorkSpace.shared.Message;

public class MessageView extends Composite implements View{
	private ArrayList<Message> messages;
	private ListBox listBox;
	private Label lblFromUser;
	private Message displayedMessage;
	private TextArea messArea;
	
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
		panel.setWidgetLeftWidth(listBox, 0.0, Unit.PX, 270.0, Unit.PX);
		panel.setWidgetTopHeight(listBox, 114.0, Unit.PX, 450.0, Unit.PX);
		listBox.setVisibleItemCount(5);
		
		messArea = new TextArea();
		panel.add(messArea);
		panel.setWidgetLeftWidth(messArea, 374.0, Unit.PX, 350.0, Unit.PX);
		panel.setWidgetTopHeight(messArea, 273.0, Unit.PX, 165.0, Unit.PX);
		
		Label lblNewLabel = new Label("Message:");
		panel.add(lblNewLabel);
		panel.setWidgetLeftWidth(lblNewLabel, 346.0, Unit.PX, 56.0, Unit.PX);
		panel.setWidgetTopHeight(lblNewLabel, 226.0, Unit.PX, 18.0, Unit.PX);
		
		lblFromUser = new Label("FromUser");
		panel.add(lblFromUser);
		panel.setWidgetLeftWidth(lblFromUser, 374.0, Unit.PX, 56.0, Unit.PX);
		panel.setWidgetTopHeight(lblFromUser, 171.0, Unit.PX, 18.0, Unit.PX);
		
		
		
		
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
					impl();
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				// TODO: display error msg
				GWT.log("message RPC call failed", caught);
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
