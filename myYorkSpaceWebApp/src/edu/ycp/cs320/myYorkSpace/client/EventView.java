package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Event;

import com.google.gwt.user.client.ui.ListBox;


public class EventView extends Composite implements View {

	private ArrayList<Event> events;
	private ListBox listBox;
	private Event displayedEvent;
	private TextArea lblEvent;
	private Label label;
	private Label lblName;
	private Label lblDescription;
	private String name;
	private String description;
	private String time;
	private ArrayList<String> invited;
	private Label dateLabel;

	public EventView(){
		
		
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
		events = new ArrayList<Event>() ;
		
		lblEvent = new TextArea();
		lblEvent.setReadOnly(true);
		panel.add(lblEvent);
		panel.setWidgetLeftWidth(lblEvent, 193.0, Unit.PX, 235.0, Unit.PX);
		panel.setWidgetTopHeight(lblEvent, 211.0, Unit.PX, 99.0, Unit.PX);
		
		listBox = new ListBox();
		panel.add(listBox);
		panel.setWidgetLeftWidth(listBox, 10.0, Unit.PX, 174.0, Unit.PX);
		panel.setWidgetTopHeight(listBox, 78.0, Unit.PX, 313.0, Unit.PX);
		
		label = new Label("");
		panel.add(label);
		panel.setWidgetLeftWidth(label, 193.0, Unit.PX, 235.0, Unit.PX);
		panel.setWidgetTopHeight(label, 143.0, Unit.PX, 28.0, Unit.PX);
		
		lblName = new Label("Event name:");
		panel.add(lblName);
		panel.setWidgetLeftWidth(lblName, 193.0, Unit.PX, 235.0, Unit.PX);
		panel.setWidgetTopHeight(lblName, 125.0, Unit.PX, 28.0, Unit.PX);
		
		lblDescription = new Label("Description:");
		panel.add(lblDescription);
		panel.setWidgetLeftWidth(lblDescription, 193.0, Unit.PX, 235.0, Unit.PX);
		panel.setWidgetTopHeight(lblDescription, 177.0, Unit.PX, 28.0, Unit.PX);
		
		Label lblEventsYouAre = new Label("Events you are invited to:");
		panel.add(lblEventsYouAre);
		panel.setWidgetLeftWidth(lblEventsYouAre, 13.0, Unit.PX, 235.0, Unit.PX);
		panel.setWidgetTopHeight(lblEventsYouAre, 57.0, Unit.PX, 28.0, Unit.PX);
		
		Button btnNewButton = new Button("New button");
		btnNewButton.setText("Create New Event");
		panel.add(btnNewButton);
		panel.setWidgetLeftWidth(btnNewButton, 10.0, Unit.PX, 174.0, Unit.PX);
		panel.setWidgetTopHeight(btnNewButton, 428.0, Unit.PX, 37.0, Unit.PX);
		
		Label lblDate = new Label("Date:");
		panel.add(lblDate);
		panel.setWidgetLeftWidth(lblDate, 193.0, Unit.PX, 56.0, Unit.PX);
		panel.setWidgetTopHeight(lblDate, 316.0, Unit.PX, 18.0, Unit.PX);
		
		dateLabel = new Label("");
		panel.add(dateLabel);
		panel.setWidgetLeftWidth(dateLabel, 193.0, Unit.PX, 153.0, Unit.PX);
		panel.setWidgetTopHeight(dateLabel, 357.0, Unit.PX, 18.0, Unit.PX);
		
		
		btnNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				MyYorkSpaceWebApp.setView(new CreateEventView ());
			}
		});
	}
	
	public void impl() {
		listBox.setVisibleItemCount(events.size());
		for(int i = 0; i < events.size(); i++)
		{
			listBox.addItem(events.get(i).getEventName());
		}
		listBox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				displayedEvent =  events.get(listBox.getSelectedIndex());
				lblEvent.setText(displayedEvent.getEventDesc());
				label.setText(displayedEvent.getEventName());
				dateLabel.setText(displayedEvent.getEventTime());
			}
		});
	}
	
	protected void GetEvents(Account host) {
		RPC.EventService.getEvents(host.getEmail(), new AsyncCallback<ArrayList<Event>>() {
			@Override
			public void onSuccess(ArrayList<Event> returnedList) {
				if (returnedList == null) {
					GWT.log("Host Account no longer exists");
				} else {
					// Successful
					events = returnedList;
					impl();
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				// TODO: display error msg
				GWT.log("get events RPC call failed", caught);
			}
		});
	}
	

	@Override
	public void activate() {
		GetEvents(Session.getInstance().getAccount());
	}
}
 