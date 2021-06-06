package activities;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Activity1 {

	static ArrayList<String> list;

	@BeforeEach
	void setUp(){
		// Initialize a new ArrayList
		list = new ArrayList<String>();

		// Add values to the list
		list.add("alpha"); // at index 0
		list.add("beta"); // at index 1
	}
	
	@Test	
	public void insertTest() {
		// Assert size of list
		assertEquals(2, list.size(), "Wrong size");

		list.add("Pankaj");

		assertEquals(3, list.size(), "Wrong size");

		// Check individual elements
		assertEquals("alpha", list.get(0), "Wrong element");
		assertEquals("beta", list.get(1), "Wrong element");
		assertEquals("Pankaj", list.get(2), "Wrong element");
	}

	// Test method to test the replace operation	
	@Test	
	public void replaceTest() {
		// Replace new element
		list.set(1, "charlie");

		// Assert size of list
		assertEquals(2, list.size(), "Wrong size");
		// Assert individual elements
		assertEquals("alpha", list.get(0), "Wrong element");
		assertEquals("charlie", list.get(1), "Wrong element");
	}

}
