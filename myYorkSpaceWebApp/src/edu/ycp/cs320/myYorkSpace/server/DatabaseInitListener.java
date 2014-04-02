package edu.ycp.cs320.myYorkSpace.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.ycp.cs320.myYorkSpace.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.myYorkSpace.server.model.persist.FakeDatabase;

public class DatabaseInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent e) {
		// Webapp is starting
		DatabaseProvider.setInstance(new FakeDatabase()); // FIXME: use a real database
		System.out.println("Initialized database!");
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		// Webapp is shutting down

	}

}
