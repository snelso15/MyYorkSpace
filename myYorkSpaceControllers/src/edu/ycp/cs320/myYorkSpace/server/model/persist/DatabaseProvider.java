package edu.ycp.cs320.myYorkSpace.server.model.persist;

public class DatabaseProvider {
	private static IDatabase theInstance;
	
	public static IDatabase getInstance() {
		return theInstance;
	}
	
	public static void setInstance(IDatabase db) {
		theInstance = db;
	}
}
