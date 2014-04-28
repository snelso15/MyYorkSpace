package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Event;

public class EventView extends Composite implements View {
	private Event eventToDisplay;
	private Label hostLabel;
//	private Label host;

	
	private Event model;

	public EventView(){
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);

		
		Label eventTitleLabel = new Label("EVENT:");
		eventTitleLabel.setStyleName("h1");
		panel.add(eventTitleLabel);
		panel.setWidgetLeftWidth(eventTitleLabel, 27.0, Unit.PX, 78.0, Unit.PX);
		panel.setWidgetTopHeight(eventTitleLabel, 0.0, Unit.PX, 41.0, Unit.PX);
		
		hostLabel = new Label("");
		panel.add(hostLabel);
		panel.setWidgetLeftWidth(hostLabel, 27.0, Unit.PX, 236.0, Unit.PX);
		panel.setWidgetTopHeight(hostLabel, 42.0, Unit.PX, 24.0, Unit.PX);
		
		Label descriptionLabel = new Label("");
		panel.add(descriptionLabel);
		panel.setWidgetLeftWidth(descriptionLabel, 27.0, Unit.PX, 331.0, Unit.PX);
		panel.setWidgetTopHeight(descriptionLabel, 72.0, Unit.PX, 18.0, Unit.PX);

	}
	
	public void setModel(Event model) {
		this.model = model;
	}
	
	public void activate() {
		if (model == null) {
			throw new IllegalStateException("Need to set an Event before activating EventView");
		}
		updateView();
	}

	private void updateView() {
		hostLabel.setText(model.getHost());
	}
	
	/*
	protected void GetEvent(Account host) {
		RPC.GetAccountService.getAccount(host.getEmail(), new AsyncCallback<Account>() {
			@Override
			public void onSuccess(Account result) {
				if (result == null) {
					GWT.log("Host Account no longer exists");
				} else {
					// Successful
					eventToDisplay = result.getEvent();
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				// TODO: display error msg
				GWT.log("Login RPC call failed", caught);
			}
		});
	}
	*/
}
 