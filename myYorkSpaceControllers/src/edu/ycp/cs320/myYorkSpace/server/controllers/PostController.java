package edu.ycp.cs320.myYorkSpace.server.controllers;

import java.util.ArrayList;

import edu.ycp.cs320.myYorkSpace.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.myYorkSpace.shared.Attachment;
import edu.ycp.cs320.myYorkSpace.shared.Post;

public class PostController {
	public void createPost(String postUser, String postText, Attachment postAttach)
	{
		Post p = new Post(postUser, postText, postAttach);
		// FIXME
		//DatabaseProvider.getInstance().createPost(p);
	}
	
	public ArrayList<Post> getPost(String postUser)
	{
		// FIXME
		return null; //DatabaseProvider.getInstance().getPosts(postUser);
	}
}
