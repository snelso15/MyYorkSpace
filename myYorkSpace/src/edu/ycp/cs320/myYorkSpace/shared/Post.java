package edu.ycp.cs320.myYorkSpace.shared;

import java.io.Serializable;

public class Post implements Serializable {

	private String postUser;
	private String postText;
	private String fromUser;
	//private Attachment postAttach;
	
	public Post(){
		
	}
	
	public Post(String postUser, String postText, String fromuser) //Attachment postAttach)
	{
		this.postUser = postUser;
		this.postText = postText;
		this.fromUser = fromuser;
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

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
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
