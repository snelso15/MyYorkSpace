package edu.ycp.cs320.myYorkSpace.shared;

import java.util.ArrayList;

public class Event {
	private int id;
	private String eventName;
	private String eventDesc;
	private String eventTime;
	private ArrayList<String> invited;
	private String host;
	
	public Event(String eventName, String eventDesc, String eventTime, ArrayList<String> invited)
	{
		this.eventName = eventName;
		this.eventDesc = eventDesc;
		this.eventTime = eventTime;
		this.invited = invited;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setEventName(String eventName)
	{
		this.eventName = eventName;
	}
	
	public String getEventName()
	{
		return this.eventName;
	}
	
	public void setEventDesc(String eventDesc)
	{
		this.eventDesc = eventDesc;
	}
	
	public String getEventDesc()
	{
		return this.eventDesc;
	}
	
	public void setEventTime(String eventTime)
	{
		this.eventTime = eventTime;
	}
	
	public String getEventTime()
	{
		return this.eventTime;
	}
	
	public void setInvited(ArrayList<String> invited)
	{
		this.invited = invited;
	}
	
	public ArrayList<String> getInvited()
	{
		return this.invited;
	}
	
	public void setHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return this.host;
	}
}
