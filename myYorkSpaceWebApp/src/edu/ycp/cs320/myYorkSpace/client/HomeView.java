package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import com.google.gwt.user.client.ui.Image;

public class HomeView extends Composite implements View {
	

	public HomeView() {
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		panel.setSize("1000px", "1000px");
		
		
		//////////////////////////////////////////////////
		
		MenuBar menuBar = new MenuBar(false);
		panel.add(menuBar);
		panel.setWidgetTopHeight(menuBar, 0.0, Unit.PX, 461.0, Unit.PX);
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
		
		Label lblNewLabel = new Label("Hello! Please select what you want to view");
		lblNewLabel.setStyleName("h1");
		lblNewLabel.setStylePrimaryName("h1");
		panel.add(lblNewLabel);
		panel.setWidgetLeftWidth(lblNewLabel, 12.0, Unit.PX, 330.0, Unit.PX);
		panel.setWidgetTopHeight(lblNewLabel, 100.0, Unit.PX, 18.0, Unit.PX);
		
		
	}
	@Override
	public void activate() {
		
		
	}
}
