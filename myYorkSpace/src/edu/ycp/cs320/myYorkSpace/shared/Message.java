package edu.ycp.cs320.myYorkSpace.shared;

public class Message {
	
	private String fromUser;
	private String toUser;
	private String messText;
	
	public Message(String fromUser, String toUser, String messText)
	{
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.messText = messText;
	}
	
	public void setFromUser(String fromUser)
	{
		this.fromUser = fromUser;
	}
	
	public String getFromUser()
	{
		return fromUser;
	}
	
	public void setToUser(String toUser)
	{
		this.toUser = toUser;
	}
	
	public String getToUser()
	{
		return toUser;
	}
	
	public void setMessText(String messText)
	{
		this.messText = messText;
	}
	
	public String getMessText()
	{
		return messText;
	}
}