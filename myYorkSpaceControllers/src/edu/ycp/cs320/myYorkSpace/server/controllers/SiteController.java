package edu.ycp.cs320.myYorkSpace.server.controllers;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.myYorkSpace.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Event;
import edu.ycp.cs320.myYorkSpace.shared.Message;
import edu.ycp.cs320.myYorkSpace.shared.Post;
import edu.ycp.cs320.myYorkSpace.shared.Site;

public class SiteController {
	//returns the 
	public Account logIn(String email, String password){
		return DatabaseProvider.getInstance().logIn(email, password);
	}
	
	public Account addUser(Account account) {
		if(verifyUser(account)){
			DatabaseProvider.getInstance().addUser(account);
			return account;
		}
		else{
			System.out.print("not a valid account");
			return null;
		}
	}
	public Account findUserByEmail(String email) {
		return DatabaseProvider.getInstance().findUserByEmail(email);
	}
	
	public Account findUserByUserName(String userName) {
		return DatabaseProvider.getInstance().findUserByUserName(userName);
	}
	
	public boolean verifyUser(Account user){
		if(validEmail(user.getEmail())&&validPassword(user.getPassword())) return true;
		else return false;
	}
	
	public boolean validEmail(String email){
		boolean valid = false;
		if(email.contains("@")&&(email.contains(".edu"))) valid=true;
		return valid;
	}
	
	public boolean validPassword(String password){
		//password must be at least 5 characters long
		if(password.length()<5)return false;
		//password must be sequence of numbers between 0-9 or capitol/lower case letters.
		boolean valid = true;
		for(int i = 0; i<password.length()-1; i++){
			if(!(password.charAt(i) >= '0' && password.charAt(i) <= '9')&&!(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')&& !(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')) valid=false;
		}
		return valid; 
	}

	public ArrayList<Event> getEventsForUser(String email) {
		
		return DatabaseProvider.getInstance().getEventsForUser(email);
	}
	
	public Event addEvent(String eventName, String eventDesc, String eventTime, ArrayList<String> invited)
	{
		Event eventToAdd = new Event(eventName, eventDesc, eventTime, invited);
		return DatabaseProvider.getInstance().addEvent(eventToAdd);
	}

	public ArrayList<Account> getFriendsOfUser(String email) {
		ArrayList<Account> friends = findUserByEmail(email).getFriends();
		return friends;
	}
	public ArrayList<Account> getNonFriendsOfUser(String email) {
		Account thisUser = findUserByEmail(email);
		ArrayList<Account> NonFriends = new ArrayList<Account>();
		ArrayList<Account> allUsers = DatabaseProvider.getInstance().getAccountList();
		for(Account user : allUsers){
			if (!thisUser.getFriends().contains(user)){
				NonFriends.add(user);
			}
		}
		return NonFriends;
	}
	
	public ArrayList<Message> getUserMessages(String user)
	{
		return DatabaseProvider.getInstance().getMessage(user);
	}
	
	public Message addMessage(String fromUser, String toUser, String messText)
	{
		Message messToAdd = new Message(fromUser, toUser, messText);
		return DatabaseProvider.getInstance().addMessage(messToAdd, toUser);
	}

	public Account addFriend(String email, Account newFriend) {
		if(!findUserByEmail(email).getFriends().contains(newFriend)){
			findUserByEmail(email).addFriend(newFriend);
			return newFriend;
		}
		else{
			System.out.println("friend already exists");
			return null;
		}
	}
	public Account addPostToUser(Account userProfileBeingShown, String fromUser, String text) {
		Post post = new Post(userProfileBeingShown.getUserName(), text, fromUser);
		return DatabaseProvider.getInstance().addPostToUser(userProfileBeingShown, post);
	}
}
