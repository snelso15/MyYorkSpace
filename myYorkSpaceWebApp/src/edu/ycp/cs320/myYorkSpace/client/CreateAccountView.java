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

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.DockPanel;

public class CreateAccountView extends Composite implements View {
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
		this.userNameTextBox.setTitle("Enter user name here");
		panel.add(userNameTextBox);
		panel.setWidgetLeftWidth(userNameTextBox, 20.0, Unit.PX, 120.0, Unit.PX);
		panel.setWidgetTopHeight(userNameTextBox, 100.0, Unit.PX, 32.0, Unit.PX);
		
		this.passwordTextBox = new PasswordTextBox();
		panel.add(passwordTextBox);
		this.passwordTextBox.setWidth("110px");
		panel.setWidgetLeftWidth(passwordTextBox, 20.0, Unit.PX, 120.0, Unit.PX);
		panel.setWidgetTopHeight(passwordTextBox, 140.0, Unit.PX, 32.0, Unit.PX);

		this.emailTextBox = new TextBox();
		panel.add(emailTextBox);
		this.emailTextBox.setWidth("110px");
		panel.setWidgetLeftWidth(emailTextBox, 20.0, Unit.PX, 120.0, Unit.PX);
		panel.setWidgetTopHeight(emailTextBox, 180.0, Unit.PX, 32.0, Unit.PX);

		this.birthdayTextBox = new TextBox();
		panel.add(birthdayTextBox);
		this.birthdayTextBox.setWidth("110px");
		panel.setWidgetLeftWidth(birthdayTextBox, 20.0, Unit.PX, 120.0, Unit.PX);
		panel.setWidgetTopHeight(birthdayTextBox, 220.0, Unit.PX, 32.0, Unit.PX);
		
		this.majorTextBox = new TextBox();
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
		
		Label userNameLabel = new Label("User Name");
		panel.add(userNameLabel);
		panel.setWidgetLeftWidth(userNameLabel, 146.0, Unit.PX, 70.0, Unit.PX);
		panel.setWidgetTopHeight(userNameLabel, 100.0, Unit.PX, 18.0, Unit.PX);
		
		Label passwordLabel = new Label("Password");
		panel.add(passwordLabel);
		panel.setWidgetLeftWidth(passwordLabel, 146.0, Unit.PX, 56.0, Unit.PX);
		panel.setWidgetTopHeight(passwordLabel, 140.0, Unit.PX, 18.0, Unit.PX);
		
		Label emailLabel = new Label("Email");
		panel.add(emailLabel);
		panel.setWidgetLeftWidth(emailLabel, 146.0, Unit.PX, 56.0, Unit.PX);
		panel.setWidgetTopHeight(emailLabel, 180.0, Unit.PX, 18.0, Unit.PX);
		
		Label birthdateLabel = new Label("Birthdate mm/dd/yyyy");
		panel.add(birthdateLabel);
		panel.setWidgetLeftWidth(birthdateLabel, 146.0, Unit.PX, 137.0, Unit.PX);
		panel.setWidgetTopHeight(birthdateLabel, 220.0, Unit.PX, 18.0, Unit.PX);
		
		Label majorLabel = new Label("Major");
		panel.add(majorLabel);
		panel.setWidgetLeftWidth(majorLabel, 146.0, Unit.PX, 56.0, Unit.PX);
		panel.setWidgetTopHeight(majorLabel, 260.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblPleaseEnterNew = new Label("Please enter new account information");
		panel.add(lblPleaseEnterNew);
		panel.setWidgetLeftWidth(lblPleaseEnterNew, 14.0, Unit.PX, 393.0, Unit.PX);
		panel.setWidgetTopHeight(lblPleaseEnterNew, 50.0, Unit.PX, 18.0, Unit.PX);
		

	}

	protected void handleAddUser() {

		
		String userName = userNameTextBox.getText();
		String password = passwordTextBox.getText();
		String email = emailTextBox.getText();
		String birthday = birthdayTextBox.getText();
		String major = majorTextBox.getText();

		Account accountToAdd = new Account();
		accountToAdd.setBirthDate(birthday);
		accountToAdd.setEmail(email);
		accountToAdd.setUserName(userName);
		accountToAdd.setMajor(major);
		accountToAdd.setPassword(password);
		
		
		
		RPC.AddUserService.AddUser(accountToAdd, new AsyncCallback<Account>() {
			@Override
			public void onSuccess(Account result) {
				if (result == null) {
					// bad data
					GWT.log("Failed.  Reenter valid data");
				} else {
					// Successful 
					Session.getInstance().setAccount(result);
					MyYorkSpaceWebApp.setView(new HomeView());
					GWT.log("Add User Successful!");
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("RPC call failed", caught);
			}
		});
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		
	}
}
