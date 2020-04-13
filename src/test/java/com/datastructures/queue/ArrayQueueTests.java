package com.datastructures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayQueueTests {

	private ArrayQueue<String> queue;

	@BeforeEach
	void setUp() throws Exception {
		queue = new ArrayQueue<>(5);
		queue.enQueue("sharath");
		queue.enQueue("kumar");
		queue.enQueue("ravi");
		queue.enQueue("vivek");
		queue.enQueue("gopal");
	}

	@Test
	void testSize() {
		assertEquals(5, queue.size());
	}

	@Test
	void testEnQueue() {
		queue.enQueue("fahad");
		assertEquals(6, queue.size());
	}

	@Test
	void testDeQueue() {
		assertEquals("sharath", queue.deQueue());
		assertEquals(4, queue.size());
	}

	@Test
	void testIsEmpty() {
		while (!queue.isEmpty()) {
			queue.deQueue();
		}
		assertTrue(queue.isEmpty());
		queue.printAll();
	}

	@Test
	void testContains() {
		assertTrue(queue.contains("ravi"));
		queue.printAll();
	}

}
