package edu.ycp.cs320.myYorkSpace.server.model.persist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Account;

public class SiteControllerTest {
	@Before
	public void setUp() {
		DatabaseProvider.setInstance(new FakeDatabase());
	}
	
	@Test
	public void testLogIn() {
		Account acct;
		SiteController controller = new SiteController();
		acct = controller.logIn("user@ycp.edu", "abc123");
		assertEquals("user@ycp.edu", acct.getEmail());
	}
}
