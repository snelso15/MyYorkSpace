package edu.ycp.cs320.myYorkSpace.shared;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import junit.framework.TestCase;

public class PostTest extends TestCase{

	private Post a;
	private Post b;
	private Post c;
	
	@Before
	protected void setUp()
	{
//		a = new Post("Taylor", "Going to the mall, who wants to come?!");
//		b = new Post("Bob", "Just got my truck back from the shop!");
//		c = new Post("Chris", "Thinking about going on a road trip, anyone else want to go?");
	}
	
	@Test
	public void testGetPostUser() {
		assertEquals("Taylor", a.getPostUser());
		assertEquals("Bob", b.getPostUser());
		assertEquals("Chris", c.getPostUser());
	}
	
	@Test
	public void testGetPostText() {
		assertEquals("Going to the mall, who wants to come?!", a.getPostText());
		assertEquals("Just got my truck back from the shop!", b.getPostText());
		assertEquals("Thinking about going on a road trip, anyone else want to go?", c.getPostText());
	}
}
