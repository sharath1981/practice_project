package com.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedSinglyLinkedListTests {
	
	private SortedSinglyLinkedList<Integer> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new SortedSinglyLinkedList<>(); 
	}

	@Test
	void testAdd() {
		list.add(4);
		list.add(4);
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(9);
		list.add(7);
		list.add(8);
		list.add(6);
		list.add(3);
		list.add(10);
		list.add(5);
		assertEquals(12, list.size());
	}

	@Test
	void testSize() {
		list.add(4);
		list.add(4);
		list.add(1);
		list.add(2);
		assertEquals(4, list.size());
	}

	@Test
	void testIsEmpty() {
		assertTrue(list.isEmpty());
	}

	@Test
	void testGetFirst() {
		list.add(4);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(2);
		assertEquals(1, list.getFirst());
	}

	@Test
	void testGetLast() {
		list.add(4);
		list.add(4);
		list.add(5);
		list.add(1);
		list.add(2);
		assertEquals(5, list.getLast());
	}

	@Test
	void testClear() {
		list.add(4);
		list.add(4);
		list.add(5);
		list.add(1);
		list.add(2);
		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	void testElementAt() {
		list.add(4);
		list.add(4);
		list.add(5);
		list.add(1);
		list.add(2);
		assertEquals(5, list.elementAt(4));
		assertEquals(1, list.elementAt(0));
		assertEquals(4, list.elementAt(2));
	}

	@Test
	void testRemove() {
		list.add(4);
		list.add(4);
		list.add(5);
		list.add(1);
		list.add(2);
		list.remove(4);
		list.remove(5);
		list.remove(1);
		assertEquals(2, list.size());
		list.printAll();
	}

}
