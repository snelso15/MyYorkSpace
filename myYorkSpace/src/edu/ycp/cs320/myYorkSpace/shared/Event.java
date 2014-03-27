package edu.ycp.cs320.myYorkSpace.shared;

import java.util.ArrayList;

public class Event {
	
	private String eventName;
	private String eventDesc;
	private String eventTime;
	private ArrayList<Account> invited;
	
	public Event(String eventName, String eventDesc, String eventTime, ArrayList<Account> invited)
	{
		this.eventName = eventName;
		this.eventDesc = eventDesc;
		this.eventTime = eventTime;
		this.invited = invited;
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
	
	public void setInvited(ArrayList<Account> invited)
	{
		this.invited = invited;
	}
	
	public ArrayList<Account> getInvited()
	{
		return this.invited;
	}
}
