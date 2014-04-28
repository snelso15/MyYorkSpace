package edu.ycp.cs320.myYorkSpace.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
	private String userName;
	private String email;
	private String birthDate;
	private String password;
	private String major;
	private Event event;//for now, every account only can have one event at a time

	private ArrayList<Account> friends;
	private ArrayList<Post> posts;
	private ArrayList<Event> events;
	
	// Default constructor
	public Account() {
	}
	
	//constructor
	public Account(String userName, String email, String password, String birthDate, String major, ArrayList<Account> friends, ArrayList<Post> posts, ArrayList<Event> events) {
		this.userName = userName;
		this.email = email;
		this.birthDate = birthDate;
		this.password = password;
		this.major = major;
		this.friends = friends;
		this.posts = posts;
		this.events = events;
	}

	//getters/setters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public ArrayList<Account> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<Account> friends) {
		this.friends = friends;
	}
	
	public ArrayList<Post> getPosts(){
		return this.posts;
	}
	public void setPosts(ArrayList<Post> posts){
		this.posts = posts;
	}
	
	public ArrayList<Event> getEvents(){
		return this.events;
	}
	
	public void setEvents(ArrayList<Event> events){
		this.events = events;
	}
}
