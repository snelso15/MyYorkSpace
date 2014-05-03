package edu.ycp.cs320.myYorkSpace.server.model.persist;

import java.util.ArrayList;

import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Message;
import edu.ycp.cs320.myYorkSpace.shared.Post;

public interface IDatabase {
	public Account logIn(String email, String password);
	public void addUser(Account userToAdd);
	public Account findUserByUserName(String name);
	public Account findUserByEmail(String email);
	public ArrayList<Message> getMessage(String user);
	public void createPost(Post postToAdd);
	public ArrayList<Post> getPosts(String postUser);
	public void addMessage(Message messToAdd, String toUser);
}

