package edu.ycp.cs320.myYorkSpace.server.model.persist;

import java.util.ArrayList;
import java.util.List;






import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Attachment;
import edu.ycp.cs320.myYorkSpace.shared.Birthday;
import edu.ycp.cs320.myYorkSpace.shared.Event;
import edu.ycp.cs320.myYorkSpace.shared.Message;
import edu.ycp.cs320.myYorkSpace.shared.Post;

public class FakeDatabase implements IDatabase {
	
	private ArrayList<Account> accountList;
	private ArrayList<Post> postList;
	private ArrayList<Message> messageList;
	private ArrayList<Event> eventList;
	
	public FakeDatabase() {
		eventList = new ArrayList<Event>();
		accountList = new ArrayList<Account>();
		
		Event event = new Event();
		event.setEventName("boring event");
		event.setEventDesc("No description required.  it is a very boring event");
		event.setInvited(null);//no one invited:(
		
		Event event2 = new Event();
		event2.setEventName("another boring event");
		event2.setEventDesc("waaaaaaaaaaaaahhhhhhhhhhhhh its boring");
		event2.setInvited(null);//no one invited:(
		
		eventList.add(event);
		eventList.add(event2);
		
		Account account= new Account();
		account.setEmail("sam@ycp.edu");
		Birthday birthday = new Birthday(5, 7, 1994);
		account.setBirthDate(birthday.toString());
		account.setMajor("Computer Engineering");
		account.setPassword("123abc");
		account.setUserName("Sam");
		account.setEvents(eventList);

 		accountList.add(account);
		
		Account account1= new Account();
		account1.setEmail("alec@ycp.edu");
		Birthday birthday1 = new Birthday(12, 7, 1993);
		account1.setBirthDate(birthday1.toString());
		account1.setMajor("Electrical Engineering");
		account1.setPassword("abc123");
		account1.setUserName("Alec");
		account1.setEvents(eventList);
		
		Account account2= new Account();
		account2.setEmail("sammy@ycp.edu");
		Birthday birthday2 = new Birthday(12, 7, 1993);
		account2.setBirthDate(birthday2.toString());
		account2.setMajor("Electrical Engineering");
		account2.setPassword("sammy");
		account2.setUserName("sammy");
		account2.setEvents(eventList);
	
		accountList.add(account2);
		

		//accountList.get(0).addFriend(account);
		
		Message message = new Message("sam", "prof", "HEYYYYYY");
		Message message1 = new Message("sam", "prof", "HEYYYY");
		Message message2 = new Message("sam", "prof", "HEYYY");
		
		ArrayList<Message> mes = new ArrayList<Message>();
		mes.add(message);
		mes.add(message1);
		mes.add(message2);
		
		Account account3= new Account();
		account3.setEmail("prof@ycp.edu");
		account3.setMessages(mes);
		Birthday birthday3 = new Birthday(11, 5, 1975);
		account3.setBirthDate(birthday3.toString());
		account3.setMajor("Mechanical Engineering");
		account3.setPassword("prof");
		account3.setUserName("Prof");
		
		
		ArrayList<Account> frnds = new ArrayList<Account>();
		frnds.add(account);
		frnds.add(account1);
		frnds.add(account2);
		
		
		account3.setFriends(frnds);
		//account3.addFriend(account);
		//account3.addFriend(account1);
		//account3.addFriend(account2);
		
		

		
		
		

		
		accountList.add(account3);
		
		for (int i = 0; i<accountList.size(); i++) {
			System.out.println("user " + i + ":");
			  System.out.println(accountList.get(i).getEmail());
		}

	}
	
	public void addUser(Account userToAdd){
			accountList.add(userToAdd);
	}
	
	public Account logIn(String email, String password) {
		Account thisUser = findUserByEmail(email);
		if(thisUser==null){
			System.out.println("Account with this Email does not exist");
			return null;
		}
		if (thisUser.getPassword().equals(password)) {
			return thisUser;
		}
		return null;
	}
	
	public Account findUserByUserName(String name) {
		for (int i = 0; i<accountList.size(); i++) {
			if (accountList.get(i).getUserName().equals(name)) {
				return accountList.get(i);
			}
		}
		return null;
	}
	
	public Account findUserByEmail(String email) {

		for (int i = 0; i<accountList.size(); i++) {
			if (accountList.get(i).getEmail().equals(email)) {
				System.out.println("user with this email exists");
				return accountList.get(i);
			}
		}
		return null;
	}
	
	public void createPost(Post postToAdd) {
		postList.add(postToAdd);
	}
	
	public ArrayList<Post> getPosts(String postUser) {
		ArrayList<Post> foundPosts = new ArrayList<Post>();
		for(Post post : postList)
		{
			if(post.getPostUser().equals(postUser))
			{
				foundPosts.add(post);
			}
		}
		return foundPosts;
	}
	
	public void addMessage(Message messToAdd, String toUser) {
		findUserByUserName(messToAdd.getFromUser()).getMessages().add(messToAdd);
		findUserByUserName(toUser).getMessages().add(messToAdd);
	}
	
	public ArrayList<Message> getMessage(String user) {
		return findUserByUserName(user).getMessages();
	}
	
	public ArrayList<Account> getAccountList() {
		return accountList;
	}

}
