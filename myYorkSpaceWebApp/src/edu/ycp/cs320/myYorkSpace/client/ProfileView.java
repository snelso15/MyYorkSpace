package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.ListBox;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Post;

import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.InlineLabel;

public class ProfileView extends Composite implements View{
	
	public ProfileView(Account userProfileBeingShown) {
		
		Session profile = Session.getInstance();
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		
		MenuBar menuBar = new MenuBar(false);
		flowPanel.add(menuBar);
		menuBar.setWidth("276px");
		
		MenuItem mntmHome = new MenuItem("Home", false, (Command) null);
		menuBar.addItem(mntmHome);
		mntmHome.
		
		MenuItemSeparator separator = new MenuItemSeparator();
		menuBar.addSeparator(separator);
		
		MenuItem mntmFriends = new MenuItem("Friends", false, (Command) null);
		menuBar.addItem(mntmFriends);
		
		MenuItemSeparator separator_1 = new MenuItemSeparator();
		menuBar.addSeparator(separator_1);
		
		MenuItem mntmMessage = new MenuItem("Message", false, (Command) null);
		menuBar.addItem(mntmMessage);
		
		MenuItemSeparator separator_2 = new MenuItemSeparator();
		menuBar.addSeparator(separator_2);
		
		MenuItem mntmEvents = new MenuItem("Events", false, (Command) null);
		menuBar.addItem(mntmEvents);
		

		MenuItemSeparator separator_3 = new MenuItemSeparator();
		menuBar.addSeparator(separator_3);
		
		String userName = userProfileBeingShown.getUserName();

		
		InlineLabel nlnlblNewInlinelabel = new InlineLabel("New InlineLabel");
		flowPanel.add(nlnlblNewInlinelabel);

		Label lblNewLabel = new Label(userName);
		flowPanel.add(lblNewLabel);
		lblNewLabel.setWidth("235px");
		
		Label lblNewLabel_1 = new Label("Posts");
		flowPanel.add(lblNewLabel_1);
		
		ListBox listBox = new ListBox();
		flowPanel.add(listBox);
		listBox.setSize("439px", "351px");
		ArrayList<Post> userPosts = profile.getAccount().getPosts();
		listBox.setVisibleItemCount(10);
		for(int i = 0; i < userPosts.size(); i++)
		{
			listBox.addItem(userPosts.get(i).getPostText());
		}
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		
	}

}
