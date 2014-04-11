package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyYorkSpaceWebApp implements EntryPoint {
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
		LoginView loginView = new LoginView();
		
		RootLayoutPanel.get().add(loginView);
		RootLayoutPanel.get().setWidgetLeftRight(loginView, 0.0, Unit.PX, 0.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(loginView, 0.0, Unit.PX, 0.0, Unit.PX);
	}
}
