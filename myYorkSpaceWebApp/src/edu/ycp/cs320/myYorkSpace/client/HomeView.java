package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;

import edu.ycp.cs320.myYorkSpace.shared.Account;

public class HomeView extends Composite implements View {
	

	public HomeView() {
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		panel.setSize("507px", "347px");
		
		PushButton profileButton = new PushButton("Profile");
		panel.add(profileButton);
		panel.setWidgetLeftWidth(profileButton, 17.0, Unit.PX, 77.0, Unit.PX);
		panel.setWidgetTopHeight(profileButton, 42.0, Unit.PX, 26.0, Unit.PX);
		profileButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				MyYorkSpaceWebApp.setView(new ProfileView(Session.getInstance().getAccount()));
			}
		});
		
		PushButton friendsButton = new PushButton("Friends");
		panel.add(friendsButton);
		panel.setWidgetLeftWidth(friendsButton, 109.0, Unit.PX, 77.0, Unit.PX);
		panel.setWidgetTopHeight(friendsButton, 42.0, Unit.PX, 26.0, Unit.PX);
		friendsButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				MyYorkSpaceWebApp.setView(new FriendsView());
			}
		});
		
		PushButton eventsButton = new PushButton("Events");
		panel.add(eventsButton);
		panel.setWidgetLeftWidth(eventsButton, 204.0, Unit.PX, 77.0, Unit.PX);
		panel.setWidgetTopHeight(eventsButton, 42.0, Unit.PX, 26.0, Unit.PX);
		eventsButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				MyYorkSpaceWebApp.setView(new EventView());
			}
		});
		
		Label lblNewLabel = new Label("Hello! Please select what you want to view");
		panel.add(lblNewLabel);
		panel.setWidgetLeftWidth(lblNewLabel, 16.0, Unit.PX, 330.0, Unit.PX);
		panel.setWidgetTopHeight(lblNewLabel, 18.0, Unit.PX, 18.0, Unit.PX);
	}
	@Override
	public void activate() {
		
		
	}
}
