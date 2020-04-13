package com.datastructures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoublyLinkedQueueTests {

	private DoublyLinkedQueue<String> queue;
	
	@BeforeEach
	void setUp() throws Exception {
		queue = new DoublyLinkedQueue<>();
	}

	@Test
	void testSize() {
		assertEquals(0, queue.size());
		queue.enqueue("sharath");
		queue.enqueue("tavant");
		assertEquals(2, queue.size());
	}

	@Test
	void testIsEmpty() {
		assertTrue(queue.isEmpty());
	}

	@Test
	void testClear() {
		queue.enqueue("sharath");
		queue.enqueue("kumar");
		queue.enqueue("tavant");
		queue.clear();
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
	}

	@Test
	void testEnqueue() {
		queue.enqueue("sharath");
		queue.enqueue("kumar");
		queue.enqueue("tavant");
		assertEquals(3, queue.size());
	}

	@Test
	void testDequeue() {
		queue.enqueue("sharath");
		queue.enqueue("kumar");
		queue.enqueue("tavant");
		assertEquals("sharath", queue.dequeue());
		assertEquals(2, queue.size());
		queue.printAll();
	}

	@Test
	void testGetFirst() {
		queue.enqueue("sharath");
		queue.enqueue("kumar");
		queue.enqueue("tavant");
		assertEquals("sharath", queue.getFirst());
	}

}
