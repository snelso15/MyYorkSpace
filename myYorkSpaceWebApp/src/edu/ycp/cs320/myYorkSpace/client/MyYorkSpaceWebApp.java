package edu.ycp.cs320.myYorkSpace.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
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

		View loginView = new LoginView();

		setView(loginView);
	}

	public static void setView(View view) {
		if (currentView != null) {
			RootLayoutPanel.get().remove(currentView);
		}
		RootLayoutPanel.get().add(view);
		RootLayoutPanel.get().setWidgetLeftRight(view, 0.0, Unit.PX, 0.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(view, 0.0, Unit.PX, 0.0, Unit.PX);

		currentView = view;
	}
	
	
}
