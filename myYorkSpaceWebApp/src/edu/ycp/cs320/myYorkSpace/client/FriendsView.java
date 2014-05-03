package edu.ycp.cs320.myYorkSpace.client;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;


import com.google.gwt.user.client.ui.MenuItemSeparator;

import edu.ycp.cs320.myYorkSpace.client.MyYorkSpaceWebApp;
import edu.ycp.cs320.myYorkSpace.client.ProfileView;
import edu.ycp.cs320.myYorkSpace.client.RPC;
import edu.ycp.cs320.myYorkSpace.client.Session;
import edu.ycp.cs320.myYorkSpace.client.View;
import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Event;

import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;

public class FriendsView extends Composite implements View {

	private ArrayList<Account> friends;
	private ListBox listBox;
	private Label userSelectedLabel;
	private Button btnAddFriend;
	private Label AddThisUserlabel;
	private ListBox listBox_1;
	private ArrayList<Account> usersToAdd;
	private Account UserSelected;


	public FriendsView(){
		
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		panel.setSize("1000px", "1000px");
		
		//////////////////////////////////////////////////
				
		MenuBar menuBar = new MenuBar(false);
		panel.add(menuBar);
		panel.setWidgetLeftWidth(menuBar, 0.0, Unit.PX, 1002.0, Unit.PX);
		panel.setWidgetTopHeight(menuBar, 0.0, Unit.PX, 1383.0, Unit.PX);
		menuBar.setSize("1000px", "1500");
	      
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

		friends = new ArrayList<Account>();
		usersToAdd = new ArrayList<Account>();
		
		listBox = new ListBox();
		panel.add(listBox);
		panel.setWidgetLeftWidth(listBox, 12.0, Unit.PX, 283.0, Unit.PX);
		panel.setWidgetTopHeight(listBox, 150.0, Unit.PX, 291.0, Unit.PX);
		
		Label lblNewLabel = new Label("Select the friend whose profile you wish to view:");
		panel.add(lblNewLabel);
		panel.setWidgetLeftWidth(lblNewLabel, 12.0, Unit.PX, 362.0, Unit.PX);
		panel.setWidgetTopHeight(lblNewLabel, 113.0, Unit.PX, 18.0, Unit.PX);
		
		listBox_1 = new ListBox();
		panel.add(listBox_1);
		panel.setWidgetLeftWidth(listBox_1, 355.0, Unit.PX, 283.0, Unit.PX);
		panel.setWidgetTopHeight(listBox_1, 150.0, Unit.PX, 291.0, Unit.PX);
		
		Label lblAddFriendsHere = new Label("Add Friends here:");
		panel.add(lblAddFriendsHere);
		panel.setWidgetLeftWidth(lblAddFriendsHere, 355.0, Unit.PX, 362.0, Unit.PX);
		panel.setWidgetTopHeight(lblAddFriendsHere, 82.0, Unit.PX, 18.0, Unit.PX);
		
		AddThisUserlabel = new Label("Add this User as friend?");
		AddThisUserlabel.setVisible(false);
		panel.add(AddThisUserlabel);
		panel.setWidgetLeftWidth(AddThisUserlabel, 355.0, Unit.PX, 362.0, Unit.PX);
		panel.setWidgetTopHeight(AddThisUserlabel, 113.0, Unit.PX, 18.0, Unit.PX);
		
		btnAddFriend = new Button("ADD FRIEND");
		btnAddFriend.setVisible(false);
		panel.add(btnAddFriend);
		panel.setWidgetLeftWidth(btnAddFriend, 512.0, Unit.PX, 126.0, Unit.PX);
		panel.setWidgetTopHeight(btnAddFriend, 114.0, Unit.PX, 30.0, Unit.PX);
		
		userSelectedLabel = new Label("");
		userSelectedLabel.setVisible(false);
		panel.add(userSelectedLabel);
		panel.setWidgetLeftWidth(userSelectedLabel, 644.0, Unit.PX, 56.0, Unit.PX);
		panel.setWidgetTopHeight(userSelectedLabel, 278.0, Unit.PX, 18.0, Unit.PX);
	}

	
	public void impl() {
		listBox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				MyYorkSpaceWebApp.setView(new ProfileView(friends.get(listBox.getSelectedIndex())));
			}
		});
		listBox.setVisibleItemCount(friends.size());
		for(int i = 0; i < friends.size(); i++)
		{
			listBox.addItem(friends.get(i).getUserName());
		}
	}
	
	public void impl2() {
		listBox_1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				userSelectedLabel.setVisible(true);
				AddThisUserlabel.setVisible(true);
				btnAddFriend.setVisible(true);
				UserSelected = usersToAdd.get(listBox_1.getSelectedIndex());
				userSelectedLabel.setText(UserSelected.getUserName());
			}
		});
		btnAddFriend.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(UserSelected != null){
					AddUser(UserSelected);
				}
			}
		});
		listBox_1.setVisibleItemCount(usersToAdd.size());
		for(int i = 0; i < usersToAdd.size(); i++)
		{
			listBox_1.addItem(usersToAdd.get(i).getUserName());
		}
	}
	
	
	protected void GetUsersToAdd(Account host) {
		RPC.FriendsService.getUsersToAdd(host.getEmail(), new AsyncCallback<ArrayList<Account>>() {
			@Override
			public void onSuccess(ArrayList<Account> returnedList) {
				if (returnedList == null) {
					GWT.log("Host Account no longer exists");
					
				} else {
					// Successful
					usersToAdd = returnedList;
					impl2();
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				// TODO: display error msg
				GWT.log("Login RPC call failed", caught);
			}
		});
	}
	
	protected void AddUser(Account newFriend) {
		RPC.FriendsService.addUser(Session.getInstance().getAccount().getEmail(), newFriend, new AsyncCallback<Account>() {
			@Override
			public void onSuccess(Account returned) {
				if (returned == null) {
					GWT.log("returned null, friend already exists?");
					
				} else {
					// Successful
					GWT.log("friend Added!");
					Session.getInstance().getAccount().getFriends().add(returned);
					MyYorkSpaceWebApp.setView(new FriendsView());
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				// TODO: display error msg
				GWT.log("Login RPC call failed", caught);
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
	@Override
	public String isA() {
		return "";
	}


	@Override
	public void activate() {
		GetFriends(Session.getInstance().getAccount());
		GetUsersToAdd(Session.getInstance().getAccount());
	}
}