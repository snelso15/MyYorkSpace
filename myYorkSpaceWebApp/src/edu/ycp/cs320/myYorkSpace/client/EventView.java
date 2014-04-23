package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Event;

public class EventView extends Composite {
	private Label hostLabel;
//	private Label host;
//	private Label eventName;
//	private Label eventdesc;
//	private Label eventTime;
	
	private Event model;

	public EventView(){
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		
		hostLabel = new Label("");
		panel.add(hostLabel);
		panel.setWidgetLeftWidth(hostLabel, 27.0, Unit.PX, 236.0, Unit.PX);
		panel.setWidgetTopHeight(hostLabel, 42.0, Unit.PX, 24.0, Unit.PX);
	}
	
	public void setModel(Event model) {
		this.model = model;
		updateView();
	}

	private void updateView() {
		hostLabel.setText(model.getHost());
	}
	protected void GetFriends() {
		RPC.loginService.logIn(username, password, new AsyncCallback<Account>() {
			@Override
			public void onSuccess(Account result) {
				if (result == null) {
					// Unknown username/password
					GWT.log("Unknown username/password");
				} else {
					// Successful login!
					GWT.log("Successful login!");
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
