package edu.ycp.cs320.myYorkSpace.shared;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BirthdayTest {
	private Birthday birthday;

	@Before
	public void setUp() {


	}
	
	@Test
	public void test() {
		Birthday birthday = new Birthday(5, 6, 1997);
		assertEquals("05/06/1997", birthday.toString());//valid
	}

}
