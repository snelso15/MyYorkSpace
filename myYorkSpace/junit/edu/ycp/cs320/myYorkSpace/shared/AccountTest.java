package edu.ycp.cs320.myYorkSpace.shared;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	private Account user;
	@Before
	public void setUp() {
		user = new Account(null, "snelso15@ycp.edu", null, "mYpassword1", null, null);
	}
	
	@Test
	public void testSomething() {
		assertEquals(true, user.verifyUser());
	}
}
