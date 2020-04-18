package com.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglyLinkedListWithTailTests {

	private SinglyLinkedListWithTail<String> list;
	
	@BeforeEach
	void setUp() throws Exception {
		list = new SinglyLinkedListWithTail<>();
	}

	@Test
	void testSize() {
		list.addFirst("A");
		list.addFirst("B");
		assertEquals(2, list.size());
		list.addLast("C");
		list.addLast("D");
		assertEquals(4, list.size());
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	void testIsEmpty() {
		assertTrue(list.isEmpty());
	}

	@Test
	void testClear() {
		list.addFirst("A");
		list.addFirst("B");
		list.addLast("C");
		list.addLast("D");
		list.clear();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}

	@Test
	void testAddFirst() {
		list.addFirst("A");
		list.addFirst("B");
		assertEquals(2, list.size());
	}
	
	@Test
	void testAddLast() {
		list.addLast("A");
		list.addLast("B");
		assertEquals(2, list.size());
	}

	@Test
	void testGetFirst() {
		list.addFirst("A");
		list.addFirst("B");
		assertEquals("B", list.getFirst());
	}

	@Test
	void testGetLast() {
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		assertEquals("A", list.getLast());
	}

}
