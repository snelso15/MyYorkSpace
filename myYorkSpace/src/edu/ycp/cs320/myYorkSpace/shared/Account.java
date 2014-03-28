package edu.ycp.cs320.myYorkSpace.shared;

import java.util.ArrayList;

public class Account {
	private String userName;
	private String email;
	private String birthDate;
	private String password;
	private String major;
	private ArrayList<Account> friends;
	//constructor
	public Account(String userName, String email, String password, String birthDate, String major, ArrayList<Account> friends) {
		this.userName = userName;
		this.email = email;
		this.birthDate = birthDate;
		this.password = password;
		this.major = major;
		this.friends = friends;
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
	public ArrayList<Account> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<Account> friends) {
		this.friends = friends;
	}
	//methods
	public boolean logIn(String email, String password){
		if(this.password==password && this.email==email)return true;
		else return false;
	}
	public boolean verifyUser(){
		if(validEmail(this.email)&&validPassword(this.password)) return true;
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
}
