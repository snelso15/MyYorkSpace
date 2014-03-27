package edu.ycp.cs320.myYorkSpace.shared;

public class Post {

	private String postUser;
	private String postText;
	
	public Post(String postUser, String postText)
	{
		this.postUser = postUser;
		this.postText = postText;
	}
	
	public void setPostUser(String postUser)
	{
		this.postUser = postUser;
	}
	
	public String getPostUser()
	{
		return this.postUser;
	}
	
	public void setPostText(String postText)
	{
		this.postText = postText;
	}
	
	public String getPostText()
	{
		return this.postText;
	}
}
