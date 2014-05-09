package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Event;

import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class CreateEventView extends Composite implements View {
	private TextBox textBox;
	private TextArea textArea; 
	private DatePicker datePicker;
	private ListBox inviteBox;
	private ListBox removeBox;
	private ArrayList<String> invited;
	private ArrayList<Account> friends;
 	
	
	public CreateEventView() {
		
		invited = new ArrayList<String> ();
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("667px", "571px");
		
		textBox = new TextBox();
		layoutPanel.add(textBox);
		layoutPanel.setWidgetLeftWidth(textBox, 20.0, Unit.PX, 226.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(textBox, 95.0, Unit.PX, 34.0, Unit.PX);
		
		textArea = new TextArea();
		layoutPanel.add(textArea);
		layoutPanel.setWidgetLeftWidth(textArea, 20.0, Unit.PX, 226.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(textArea, 198.0, Unit.PX, 82.0, Unit.PX);
		
		Button returnButton = new Button("Return to Events");
		layoutPanel.add(returnButton);
		layoutPanel.setWidgetLeftWidth(returnButton, 20.0, Unit.PX, 140.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(returnButton, 15.0, Unit.PX, 30.0, Unit.PX);
		returnButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				MyYorkSpaceWebApp.setView(new EventView());
			}
		});
		
		Button CreateEventButton = new Button("Create this Event");
		layoutPanel.add(CreateEventButton);
		layoutPanel.setWidgetLeftWidth(CreateEventButton, 20.0, Unit.PX, 140.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(CreateEventButton, 486.0, Unit.PX, 30.0, Unit.PX);
		CreateEventButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handleAddEvent();
			}
		});
		
		Label EventDescLabel = new Label("Enter Event Description");
		layoutPanel.add(EventDescLabel);
		layoutPanel.setWidgetLeftWidth(EventDescLabel, 20.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(EventDescLabel, 169.0, Unit.PX, 18.0, Unit.PX);
		
		Label EventNameLabel = new Label("Enter Event Name");
		layoutPanel.add(EventNameLabel);
		layoutPanel.setWidgetLeftWidth(EventNameLabel, 20.0, Unit.PX, 242.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(EventNameLabel, 71.0, Unit.PX, 18.0, Unit.PX);
		
		datePicker = new DatePicker();
		layoutPanel.add(datePicker);
		layoutPanel.setWidgetLeftWidth(datePicker, 279.0, Unit.PX, 235.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(datePicker, 96.0, Unit.PX, 191.0, Unit.PX);
		
		inviteBox = new ListBox();
		layoutPanel.add(inviteBox);
		layoutPanel.setWidgetLeftWidth(inviteBox, 20.0, Unit.PX, 140.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(inviteBox, 319.0, Unit.PX, 123.0, Unit.PX);
		inviteBox.setVisibleItemCount(5);
		
		Label lblInvitePeople = new Label("Click to invite");
		layoutPanel.add(lblInvitePeople);
		layoutPanel.setWidgetLeftWidth(lblInvitePeople, 20.0, Unit.PX, 140.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblInvitePeople, 295.0, Unit.PX, 18.0, Unit.PX);
		
		removeBox = new ListBox();
		removeBox.setVisibleItemCount(5);
		layoutPanel.add(removeBox);
		layoutPanel.setWidgetLeftWidth(removeBox, 281.0, Unit.PX, 140.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(removeBox, 319.0, Unit.PX, 123.0, Unit.PX);
		
		Label lblClickToUninvite = new Label("Click to un-invite");
		layoutPanel.add(lblClickToUninvite);
		layoutPanel.setWidgetLeftWidth(lblClickToUninvite, 279.0, Unit.PX, 140.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblClickToUninvite, 295.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblSelectDateOf = new Label("Select date of the event");
		layoutPanel.add(lblSelectDateOf);
		layoutPanel.setWidgetLeftWidth(lblSelectDateOf, 268.0, Unit.PX, 140.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblSelectDateOf, 71.0, Unit.PX, 18.0, Unit.PX);
		datePicker.getValue();
	}
	
	protected void handleAddEvent() {
		String eventName = textBox.getText();
		String eventDesc = textArea.getText();
		String eventDate = datePicker.getValue().toString();
		for(int i = 0; i< removeBox.getItemCount(); i++){
			invited.add(removeBox.getValue(i));
		}

		RPC.EventService.addEvent(eventName, eventDesc, eventDate, invited, new AsyncCallback<Event>() {
			@Override
			public void onSuccess(Event returnedEvent) {
				if (returnedEvent == null) {
					GWT.log("returned null?");
				} else {
					// Successful
					MyYorkSpaceWebApp.setView(new EventView());
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				// TODO: display error msg
				GWT.log("add event RPC call failed", caught);
			}
		});
	}
	
	public void impl(){
		inviteBox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				removeBox.addItem(inviteBox.getItemText(inviteBox.getSelectedIndex()));
				inviteBox.removeItem(inviteBox.getSelectedIndex());
			}
		});
		inviteBox.setVisibleItemCount(friends.size());
		for(int i = 0; i < friends.size(); i++)
		{
			inviteBox.addItem(friends.get(i).getUserName());
		}
		removeBox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				inviteBox.addItem(removeBox.getItemText(removeBox.getSelectedIndex()));
				removeBox.removeItem(removeBox.getSelectedIndex());
			}
		});
	}

	@Override
	public void activate() {
		RPC.FriendsService.getFriends(Session.getInstance().getAccount().getEmail(), new AsyncCallback<ArrayList<Account>>() {
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
}
