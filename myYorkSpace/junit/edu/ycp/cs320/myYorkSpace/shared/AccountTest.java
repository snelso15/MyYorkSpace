package edu.ycp.cs320.myYorkSpace.shared;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	private Account user;
	private Account user2;
	private Account user3;
	@Before
	public void setUp() {
		//user = new Account("Sam", "snelso15@ycp.edu", "mYpassword1", "05/07/1994",  "CE", null);
		//user2 = new Account("Alec", "snelso15ycp.edu", "mYpassword1", "05/07/1994",  "ME", null);
		
		ArrayList<Account> friends = new ArrayList<Account>();
		friends.add(user);
		friends.add(user2);
		
		//user3 = new Account("Alec", "snelso15ycp.edu", "mYpassword1", "05/07/1994",  "ME", friends);
	}
	
	@Test
	public void testUserVerification() {
	//	assertEquals(true, user.verifyUser());
	//	assertEquals(false, user2.verifyUser());
//		assertEquals(true, user2.validPassword("4Snsamnn567"));//valid
//		assertEquals(false, user2.validPassword("4Sn+"));//not long enough
//		assertEquals(true, user2.validEmail("snelso15@ycp.edu"));//valid
//		assertEquals(false, user2.validEmail("snelso15.edu"));//missing @ycp 
//		assertEquals(false, user2.validEmail("snelso15@ycp"));//missing .edu 
//		
//		assertEquals(true, user.verifyUser());//missing .edu 
//		assertEquals(false, user2.verifyUser());//missing .edu 
	}
	@Test
	public void testGetEmail() {
		assertEquals("snelso15@ycp.edu", user.getEmail());//valid
	}
	@Test
	public void testGetPassword() {
		assertEquals("mYpassword1", user.getPassword());//valid
	}
	@Test
	public void testGetBirthdate() {
		assertEquals("05/07/1994", user.getBirthDate());//valid
	}
	@Test
	public void testGetUserName() {
		assertEquals("Sam", user.getUserName());//valid
		assertEquals("Alec", user2.getUserName());//valid
	}
	public void testGetMajor() {
		assertEquals("ME", user2.getMajor());//valid
	}
	public void testGetFriends() {
		assertEquals(user, user3.getFriends().get(0));//valid
	}
	public void testLogIn() {
//		assertEquals(true, user.logIn("snelso15@ycp.edu", "mYpassword1"));//valid
	}

	
}

