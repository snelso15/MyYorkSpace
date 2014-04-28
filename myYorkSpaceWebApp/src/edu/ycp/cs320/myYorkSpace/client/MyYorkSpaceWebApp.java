package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import edu.ycp.cs320.myYorkSpace.shared.Account;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyYorkSpaceWebApp implements EntryPoint {
	private static View currentView;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		/*	
		CreateAccountView createAccountView = new CreateAccountView();
		
		RootLayoutPanel.get().add(createAccountView);
		RootLayoutPanel.get().setWidgetLeftRight(createAccountView, 0.0, Unit.PX, 0.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(createAccountView, 0.0, Unit.PX, 0.0, Unit.PX);
	*/

		View loginView = new LoginView();

//		RootLayoutPanel.get().add(loginView);
//		RootLayoutPanel.get().setWidgetLeftRight(loginView, 0.0, Unit.PX, 0.0, Unit.PX);
//		RootLayoutPanel.get().setWidgetTopBottom(loginView, 0.0, Unit.PX, 0.0, Unit.PX);
//		Account account= new Account();
//		account.setEmail("sam@ycp.edu");
//		View eventView = new EventView(account);

		setView(loginView);
	}

	public static void setView(View view) {
		if (currentView != null) {
			RootLayoutPanel.get().remove(currentView);
		}
		
		RootLayoutPanel.get().add(view);
		RootLayoutPanel.get().setWidgetLeftRight(view, 0.0, Unit.PX, 0.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(view, 0.0, Unit.PX, 0.0, Unit.PX);
		
		// activate the view
		view.activate();
		
		currentView = view;
	}
	
	
}
