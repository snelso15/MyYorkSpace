package edu.ycp.cs320.myYorkSpace.shared;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import junit.framework.TestCase;


public class MessageTest extends TestCase{

	private Message a;
	private Message b;
	private Message c;
	
	@Before
	protected void setUp()
	{
		a = new Message("Bob", "Chris", "Hey Chris, you busy tonight?");
		b = new Message("Chris", "Bob", "Not really. Why? Whats up?");
		c = new Message("Bob", "Chris", "A bunch of us were going to go fishing, thought you might want to come");
	}
	
	@Test
	public void testGetFromUser() {
		assertEquals("Bob", a.getFromUser());
		assertEquals("Chris", b.getFromUser());
		assertEquals("Bob", c.getFromUser());
	}
	
	@Test
	public void testGetToUser() {
		assertEquals("Chris", a.getToUser());
		assertEquals("Bob", b.getToUser());
		assertEquals("Chris", c.getToUser());
	}
	
	@Test
	public void testGetMessText() {
		assertEquals("Hey Chris, you busy tonight?", a.getMessText());
		assertEquals("Not really. Why? Whats up?", b.getMessText());
		assertEquals("A bunch of us were going to go fishing, thought you might want to come", c.getMessText());
	}

}
