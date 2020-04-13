package com.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.datastructures.linkedlist.SinglyLinkedList;

class SinglyLinkedListTests {

	private SinglyLinkedList<String> list;
	
	@BeforeEach
	void setUp() throws Exception {
		list = new SinglyLinkedList<>();
	}
	
	@Test
	void testSize() {
		list.addToFront("sharath");
		list.addToFront("kumar");
		list.addToFront("b");
		assertEquals(3, list.size());
		list.addToBack("Java");
		list.addToBack("Javascript");
		list.addToBack("Spring");
		assertEquals(6, list.size());
		list.remove("b");
		list.remove("sharath");
		list.remove("Javascript");
		list.remove("Spring");
		list.printAll();
		assertEquals(2, list.size());
		list.clear();
		assertEquals(0, list.size());
	}
	
	@Test
	void testIsEmpty() {
		list.addToFront("sharath");
		list.addToFront("kumar");
		list.addToBack("Java");
		list.addToBack("Javascript");
		list.clear();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}
	
	@Test
	void testClear() {
		list.addToFront("sharath");
		list.addToFront("kumar");
		list.addToBack("Java");
		list.addToBack("Javascript");
		list.clear();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}
	
	@Test
	void testGetFirst() {
		list.addToFront("sharath");
		assertEquals("sharath", list.getFirst());
		list.addToFront("kumar");
		assertEquals("kumar", list.getFirst());
		list.addToBack("Java");
		list.addToBack("Javascript");
		assertEquals("kumar", list.getFirst());
	}
	
	@Test
	void testGetLast() {
		list.addToFront("sharath");
		assertEquals("sharath", list.getLast());
		list.addToFront("kumar");
		assertEquals("sharath", list.getLast());
		list.addToBack("Java");
		list.addToBack("Javascript");
		assertEquals("Javascript", list.getLast());
	}
	
	@Test
	void testAddToFront() {
		list.addToFront("sharath");
		assertEquals("sharath", list.getFirst());
		assertEquals("sharath", list.getLast());
		list.addToFront("kumar");
		assertEquals("kumar", list.getFirst());
		assertEquals("sharath", list.getLast());
		list.addToBack("Java");
		assertEquals("kumar", list.getFirst());
		assertEquals("Java", list.getLast());
		assertEquals(3, list.size());
		assertFalse(list.isEmpty());
	}
	
	@Test
	void testAddToBack() {
		list.addToBack("Java");
		assertEquals("Java", list.getFirst());
		assertEquals("Java", list.getLast());
		list.addToBack("Javascript");
		assertEquals("Java", list.getFirst());
		assertEquals("Javascript", list.getLast());
		list.addToFront("sharath");
		assertEquals("sharath", list.getFirst());
		assertEquals("Javascript", list.getLast());
		assertEquals(3, list.size());
		assertFalse(list.isEmpty());
	}
	
	@Test
	void testElementAt() {
		list.addToFront("sharath");
		list.addToFront("kumar");
		list.addToBack("Java");
		list.addToBack("Javascript");
		assertEquals("sharath", list.elementAt(1));
		assertEquals("Javascript", list.elementAt(3));
	}
	
	@Test
	@DisplayName("Remove sharath, b")
	void testRemove() {
		list.addToFront("sharath");
		list.addToFront("kumar");
		list.addToBack("Java");
		list.addToBack("Javascript");
		list.remove("sharath");
		assertEquals(3, list.size());
	}
}
