package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.layout.client.Layout;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

import edu.ycp.cs320.myYorkSpace.shared.Account;

public class LoginView extends Composite implements View {
	private TextBox userNameTextBox;
	private PasswordTextBox passwordTextBox;

	public LoginView() {
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		
		this.userNameTextBox = new TextBox();
		this.userNameTextBox.setWidth("110px");
		panel.add(userNameTextBox);
		panel.setWidgetLeftWidth(userNameTextBox, 20.0, Unit.PX, 120.0, Unit.PX);
		panel.setWidgetTopHeight(userNameTextBox, 100.0, Unit.PX, 32.0, Unit.PX);
		
		this.passwordTextBox = new PasswordTextBox();
		panel.add(passwordTextBox);
		this.passwordTextBox.setWidth("110px");
		panel.setWidgetLeftWidth(passwordTextBox, 20.0, Unit.PX, 120.0, Unit.PX);
		panel.setWidgetTopHeight(passwordTextBox, 140.0, Unit.PX, 32.0, Unit.PX);
		
		Button loginButton = new Button("Log in");
		loginButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handleLogin();
			}
		});
		panel.add(loginButton);
		panel.setWidgetLeftWidth(loginButton, 20.0, Unit.PX, 80.0, Unit.PX);
		panel.setWidgetTopHeight(loginButton, 180.0, Unit.PX, 32.0, Unit.PX);
	}
	
	@Override
	public void activate() {
		// no special initialization to do
	}

	protected void handleLogin() {
		String username = userNameTextBox.getText();
		String password = passwordTextBox.getText();
		
		RPC.loginService.logIn(username, password, new AsyncCallback<Account>() {
			@Override
			public void onSuccess(Account result) {
				if (result == null) {
					// Unknown username/password
					GWT.log("Unknown username/password");
				} else {
					// Successful login!
					GWT.log("Successful login!");
					Session.getInstance().setAccount(result);
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
