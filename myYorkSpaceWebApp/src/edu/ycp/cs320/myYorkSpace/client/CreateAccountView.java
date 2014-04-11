package edu.ycp.cs320.myYorkSpace.client;

import java.util.ArrayList;

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

public class CreateAccountView extends Composite {
	private TextBox userNameTextBox;
	private PasswordTextBox passwordTextBox;
	private TextBox emailTextBox;
	private TextBox birthdayTextBox;
	private TextBox majorTextBox;


	public CreateAccountView() {
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		
		this.userNameTextBox = new TextBox();
		this.userNameTextBox.setWidth("110px");
		//this.userNameTextBox.setTitle(title);
		panel.add(userNameTextBox);
		panel.setWidgetLeftWidth(userNameTextBox, 20.0, Unit.PX, 120.0, Unit.PX);
		panel.setWidgetTopHeight(userNameTextBox, 100.0, Unit.PX, 32.0, Unit.PX);
		
		this.passwordTextBox = new PasswordTextBox();
		panel.add(passwordTextBox);
		this.passwordTextBox.setWidth("110px");
		panel.setWidgetLeftWidth(passwordTextBox, 20.0, Unit.PX, 120.0, Unit.PX);
		panel.setWidgetTopHeight(passwordTextBox, 140.0, Unit.PX, 32.0, Unit.PX);

		this.emailTextBox = new PasswordTextBox();
		panel.add(emailTextBox);
		this.emailTextBox.setWidth("110px");
		panel.setWidgetLeftWidth(emailTextBox, 20.0, Unit.PX, 120.0, Unit.PX);
		panel.setWidgetTopHeight(emailTextBox, 180.0, Unit.PX, 32.0, Unit.PX);

		this.birthdayTextBox = new PasswordTextBox();
		panel.add(birthdayTextBox);
		this.birthdayTextBox.setWidth("110px");
		panel.setWidgetLeftWidth(birthdayTextBox, 20.0, Unit.PX, 120.0, Unit.PX);
		panel.setWidgetTopHeight(birthdayTextBox, 220.0, Unit.PX, 32.0, Unit.PX);
		
		this.majorTextBox = new PasswordTextBox();
		panel.add(majorTextBox);
		this.majorTextBox.setWidth("110px");
		panel.setWidgetLeftWidth(majorTextBox, 20.0, Unit.PX, 120.0, Unit.PX);
		panel.setWidgetTopHeight(majorTextBox, 260.0, Unit.PX, 32.0, Unit.PX);
		
		Button creatUserButton = new Button("Create Account");
		creatUserButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handleAddUser();
			}
		});
		panel.add(creatUserButton);
		panel.setWidgetLeftWidth(creatUserButton, 40.0, Unit.PX, 80.0, Unit.PX);
		panel.setWidgetTopHeight(creatUserButton, 400.0, Unit.PX, 32.0, Unit.PX);
	}

	protected void handleAddUser() {

		
		String userName = userNameTextBox.getText();
		String password = passwordTextBox.getText();
		String email = emailTextBox.getText();
		String birthday = birthdayTextBox.getText();
		String major = majorTextBox.getText();

		
		
		Account accountToAdd = new Account(userName, email, password,  birthday, major, null);
		
		RPC.AddUserService.AddUser(accountToAdd, new AsyncCallback<Account>() {
			@Override
			public void onSuccess(Account result) {
				if (result == null) {
					// Unknown username/password
					GWT.log("Failed.  Reenter valid data");
				} else {
					// Successful login!
					GWT.log("Add User Successful!");
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
