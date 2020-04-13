package com.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularSinglyLinkedListTests {

	private CircularSinglyLinkedList<String> list;
	
	@BeforeEach
	void setUp() throws Exception {
		list = new CircularSinglyLinkedList<>();
	}

	@Test
	void testSize() {
		list.addFirst("sharath");
		list.addFirst("ravi");
		list.addFirst("vivek");
		list.printAll();
		assertEquals(3, list.size());
	}

	@Test
	void testIsEmpty() {
		assertTrue(list.isEmpty());
	}

	@Test
	void testClear() {
		list.addFirst("sharath");
		list.addFirst("ravi");
		list.addFirst("vivek");
		assertEquals(3, list.size());
		list.clear();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}

	@Test
	void testAddFirst() {
		list.addFirst("sharath");
		list.addFirst("ravi");
		list.addFirst("vivek");
		assertEquals(3, list.size());
		assertEquals("vivek", list.getFirst());
		assertEquals("sharath", list.getLast());
	}
	
	@Test
	void testAddLast() {
		list.addLast("sharath");
		list.addLast("ravi");
		list.addLast("vivek");
		assertEquals(3, list.size());
		assertEquals("sharath", list.getFirst());
		assertEquals("vivek", list.getLast());
	}
	
	@Test
	void testGetFirst() {
		list.addFirst("sharath");
		assertEquals("sharath", list.getFirst());
		list.addFirst("kumar");
		list.addFirst("vivek");
		assertEquals("vivek", list.getFirst());
	}
	
	@Test
	void testGetLast() {
		list.addFirst("sharath");
		assertEquals("sharath", list.getLast());
		list.addFirst("kumar");
		list.addFirst("vivek");
		assertEquals("sharath", list.getLast());
	}

}
