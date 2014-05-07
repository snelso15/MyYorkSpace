package edu.ycp.cs320.myYorkSpace.shared;

import java.io.Serializable;

public class Post implements Serializable {

	private String postUser;
	private String postText;
	//private Attachment postAttach;
	
	public Post(){
		
	}
	
	public Post(String postUser, String postText) //Attachment postAttach)
	{
		this.postUser = postUser;
		this.postText = postText;
		//this.postAttach = postAttach;
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
	
//	public void setPostAttach(Attachment postAttach)
//	{
//		this.postAttach = postAttach;
//	}
//	
//	public Attachment getPostAttchment()
//	{
//		return this.postAttach;
//	}
}
