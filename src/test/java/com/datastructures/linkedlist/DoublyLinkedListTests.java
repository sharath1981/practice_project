package com.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTests {

	private DoublyLinkedList<String> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new DoublyLinkedList<>();
	}

	@Test
	void testSize() {
		assertEquals(0, list.size());
		list.addFirst("sharath");
		list.addFirst("kumar");
		list.addFirst("akshay");
		assertEquals(3, list.size());
		list.addLast("vivek");
		list.addLast("ravi");
		list.addLast("yaseen");
		assertEquals(6, list.size());
		list.removeFirst();
		list.removeLast();
		assertEquals(4, list.size());
		list.remove("vivek");
		assertEquals(3, list.size());
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	void testIsEmpty() {
		assertTrue(list.isEmpty());
		list.addFirst("sharath");
		list.addLast("kumar");
		list.addFirst("akshay");
		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	void testClear() {
		list.addFirst("sharath");
		list.addLast("kumar");
		list.addFirst("akshay");
		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	void testAddFirst() {
		list.addFirst("sharath");
		list.addFirst("kumar");
		list.addFirst("akshay");
		assertEquals(3, list.size());
	}

	@Test
	void testAddLast() {
		list.addLast("sharath");
		list.addLast("kumar");
		list.addLast("akshay");
		assertEquals(3, list.size());
	}

	@Test
	void testGetFirst() {
		list.addFirst("kumar");
		assertEquals("kumar", list.getFirst());
		list.addFirst("akshay");
		list.addLast("vivek");
		assertEquals("akshay", list.getFirst());
	}

	@Test
	void testGetLast() {
		list.addFirst("kumar");
		assertEquals("kumar", list.getLast());
		list.addFirst("akshay");
		list.addLast("vivek");
		list.addLast("ravi");
		assertEquals("ravi", list.getLast());
	}

	@Test
	void testRemove() {
		list.addFirst("sharath");
		list.addLast("kumar");
		list.addFirst("akshay");
		list.remove("sharath");
		assertEquals(2, list.size());
	}

	@Test
	void testRemoveFirst() {
		list.addFirst("sharath");
		list.addLast("kumar");
		list.addFirst("akshay");
		list.removeFirst();
		assertEquals(2, list.size());
	}

	@Test
	void testRemoveLast() {
		list.addFirst("sharath");
		list.addLast("kumar");
		list.addFirst("akshay");
		list.removeLast();
		assertEquals(2, list.size());
	}

	@Test
	void testElementAt() {
		list.addFirst("sharath");
		list.addLast("kumar");
		list.addFirst("akshay");
		assertEquals("kumar", list.elementAt(2));
	}

}
