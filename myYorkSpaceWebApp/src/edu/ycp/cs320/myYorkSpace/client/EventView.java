package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Label;
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
	private Label lblEvent;

	public EventView(){
		events = new ArrayList<Event>() ;
		
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		
		lblEvent = new Label("Event: ");
		panel.add(lblEvent);
		panel.setWidgetLeftWidth(lblEvent, 129.0, Unit.PX, 462.0, Unit.PX);
		panel.setWidgetTopHeight(lblEvent, 63.0, Unit.PX, 61.0, Unit.PX);
		
		listBox = new ListBox();
		panel.add(listBox);
		panel.setWidgetLeftWidth(listBox, 27.0, Unit.PX, 65.0, Unit.PX);
		panel.setWidgetTopHeight(listBox, 24.0, Unit.PX, 213.0, Unit.PX);
		
		GetEvents(Session.getInstance().getAccount());
	}
	
	public void activate() {

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
					activate();
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				// TODO: display error msg
				GWT.log("Login RPC call failed", caught);
			}
		});
	}
}
 