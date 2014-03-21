package edu.ycp.cs320.myYorkSpace.shared;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	private Account user;
	private Site site;
	@Before
	public void setUp() {
		user = new Account(null, "snelso15@ycp.edu", null, "mYpassword1", null, null);
		site = new Site();
		site.addUser(user);
	}
	
	@Test
	public void testSomething() {
		assertEquals(true, site.getUsers());
	}
}
