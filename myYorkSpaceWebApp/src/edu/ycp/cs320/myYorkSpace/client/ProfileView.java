package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.ListBox;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Post;

import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.TextArea;

public class ProfileView extends Composite implements View{
	
	
	private TextArea textArea;
	private ListBox listBox;
	private ArrayList<Post> userPosts;
	private Button btnNewButton;
	private TextArea textArea_1;
	private Account userProfileBeingShown;
	
	public ProfileView(Account userProfileBeingShown) {
		

		this.userProfileBeingShown = userProfileBeingShown;
		Session profile = Session.getInstance();
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		panel.setSize("1000px", "1000px");
		
		
		//////////////////////////////////////////////////
		MenuBar menuBar = new MenuBar(false);
		panel.add(menuBar);
		panel.setWidgetLeftWidth(menuBar, 0.0, Unit.PX, 1002.0, Unit.PX);
		panel.setWidgetTopHeight(menuBar, 0.0, Unit.PX, 1000.0, Unit.PX);
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
		
		
		
		String userName = userProfileBeingShown.getUserName();
		
		Label lblsPosts = new Label(userName + "'s posts:");
		panel.add(lblsPosts);
		panel.setWidgetLeftWidth(lblsPosts, 12.0, Unit.PX, 200.0, Unit.PX);
		panel.setWidgetTopHeight(lblsPosts, 88.0, Unit.PX, 18.0, Unit.PX);
		
		
		listBox = new ListBox();
		panel.add(listBox);
		panel.setWidgetLeftWidth(listBox, 12.0, Unit.PX, 170.0, Unit.PX);
		panel.setWidgetTopHeight(listBox, 135.0, Unit.PX, 222.0, Unit.PX);
		listBox.setSize("200px", "200px");
		userPosts = userProfileBeingShown.getPosts();
		listBox.setVisibleItemCount(10);
		
		textArea = new TextArea();
		panel.add(textArea);
		panel.setWidgetLeftWidth(textArea, 218.0, Unit.PX, 151.0, Unit.PX);
		panel.setWidgetTopHeight(textArea, 156.0, Unit.PX, 50.0, Unit.PX);
		
		Label lblNewLabel = new Label("click to view:");
		panel.add(lblNewLabel);
		panel.setWidgetLeftWidth(lblNewLabel, 12.0, Unit.PX, 118.0, Unit.PX);
		panel.setWidgetTopHeight(lblNewLabel, 111.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblPost = new Label("Selected post:");
		panel.add(lblPost);
		panel.setWidgetLeftWidth(lblPost, 218.0, Unit.PX, 151.0, Unit.PX);
		panel.setWidgetTopHeight(lblPost, 135.0, Unit.PX, 18.0, Unit.PX);
		

		

		for(int i = 0; i < userPosts.size(); i++)
		{
			if(userPosts.get(i).getFromUser()!= null){
				listBox.addItem(userPosts.get(i).getFromUser()+": "+userPosts.get(i).getPostText());
			}else{
				listBox.addItem("anonymous: "+ userPosts.get(i).getPostText());
			}
		}
		listBox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(listBox.getSelectedIndex() >= 0){
					textArea.setText(userPosts.get(listBox.getSelectedIndex()).getPostText());
				}
			}
		});
		
		textArea_1 = new TextArea();
		panel.add(textArea_1);
		panel.setWidgetLeftWidth(textArea_1, 218.0, Unit.PX, 157.0, Unit.PX);
		panel.setWidgetTopHeight(textArea_1, 262.0, Unit.PX, 73.0, Unit.PX);
		
		btnNewButton = new Button("New button");
		btnNewButton.setText("Post to "+  userProfileBeingShown.getUserName() + "'s profile");
		panel.add(btnNewButton);
		panel.setWidgetLeftWidth(btnNewButton, 218.0, Unit.PX, 151.0, Unit.PX);
		panel.setWidgetTopHeight(btnNewButton, 226.0, Unit.PX, 30.0, Unit.PX);
		btnNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//add rpc to make this store
				if(textArea_1.getText() != null && textArea_1.getText() != "" ){
					addPost(textArea_1.getText());
				}
			}
		});
	} 
	
	
	protected void addPost(String text) {
		RPC.ProfileService.addPostToUser(userProfileBeingShown, Session.getInstance().getAccount().getUserName(), text, new AsyncCallback<Account>() {
			@Override
			public void onSuccess(Account returned) {
				if (returned == null) {
					GWT.log("returned null?");
				} else {
					GWT.log("Post Added!");
					// Successful
					MyYorkSpaceWebApp.setView(new ProfileView(returned));
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				// TODO: display error msg
				GWT.log("add event RPC call failed", caught);
			}
		});
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		
	}
}
