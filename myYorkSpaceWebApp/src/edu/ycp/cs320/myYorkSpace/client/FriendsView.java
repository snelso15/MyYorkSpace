package edu.ycp.cs320.myYorkSpace.client;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;

import edu.ycp.cs320.myYorkSpace.client.MyYorkSpaceWebApp;
import edu.ycp.cs320.myYorkSpace.client.ProfileView;
import edu.ycp.cs320.myYorkSpace.client.RPC;
import edu.ycp.cs320.myYorkSpace.client.Session;
import edu.ycp.cs320.myYorkSpace.client.View;
import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Event;

public class FriendsView extends Composite implements View {

	private List<Account> friends;
	private ListBox listBox;


	public FriendsView(){
		
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		
		
		listBox = new ListBox();
		panel.add(listBox);
		panel.setWidgetLeftWidth(listBox, 27.0, Unit.PX, 63.0, Unit.PX);
		panel.setWidgetTopHeight(listBox, 24.0, Unit.PX, 100.0, Unit.PX);
		
		GetFriends(Session.getInstance().getAccount());

	}
	@Override
	public void activate() {
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
	
	protected void GetFriends(Account host) {
		RPC.FriendsService.getFriends(host.getEmail(), new AsyncCallback<List<Account>>() {
			@Override
			public void onSuccess(List<Account> returnedList) {
				if (returnedList == null) {
					GWT.log("Host Account no longer exists");
				} else {
					// Successful
					friends = returnedList;
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