package edu.ycp.cs320.myYorkSpace.shared;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class EventTest extends TestCase
{
	private Event a;
	private Event b;
	private Event c;
	private ArrayList<String> invited_a;
	private ArrayList<String> invited_b;
	private ArrayList<String> invited_c;
	
	@Before
	protected void setUp() throws Exception
	{
		invited_a = new ArrayList<String>(Arrays.asList("Alice", "Bob", "Chris", "Marry", "John"));
		invited_b = new ArrayList<String>(Arrays.asList("Bob", "Taylor", "Brian", "Becky"));
		invited_c = new ArrayList<String>(Arrays.asList("Chris", "Taylor", "John", "Marry", "Thomas"));
		a = new Event("Summer Party", "Bonfire party out by the lake", "June 20th, 8:00pm to 4:00am", invited_a);
		b = new Event("Fishing Trip", "Fishing trip up to lake Erie. Staying in a cabin in the woods, bring everything you need", "June 30th - July 2nd", invited_b);
		c = new Event("Target Practice", "Target practice at the shooting range.  Bring your own ammo.", "April 20th, 10:00am to 4:00pm", invited_c);
	}

	@Test
	public void testGetEventName() {
		assertEquals("Summer Party", a.getEventName());
		assertEquals("Fishing Trip", b.getEventName());
		assertEquals("Target Practice", c.getEventName());		
	}
	
	@Test
	public void testGetEventDesc() {
		assertEquals("Bonfire party out by the lake", a.getEventDesc());
		assertEquals("Fishing trip up to lake Erie. Staying in a cabin in the woods, bring everything you need", b.getEventDesc());
		assertEquals("Target practice at the shooting range.  Bring your own ammo.", c.getEventDesc());		
	}
	
	@Test
	public void testGetEventTime() {
		assertEquals("June 20th, 8:00pm to 4:00am", a.getEventTime());
		assertEquals("June 30th - July 2nd", b.getEventTime());
		assertEquals("April 20th, 10:00am to 4:00pm", c.getEventTime());		
	}
	
	@Test
	public void testGetInvited() {
		assertEquals(5, a.getInvited().size());
		assertEquals(4, b.getInvited().size());
		assertEquals(5, c.getInvited().size());
		
		assertEquals("Bob", a.getInvited().get(1));
		assertEquals("Brian", b.getInvited().get(2));
		assertEquals("Thomas", c.getInvited().get(4));
	}

}
