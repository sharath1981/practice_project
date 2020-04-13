/**
 * 
 */
package com.datastructures.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Sharath Kumar B <sharath1981@gmail.com>
 *
 */
class ArrayStackTests {

	private ArrayStack<String> stack;

	@BeforeEach
	void setUp() throws Exception {
		stack = new ArrayStack<>(5);
		stack.push("sharath");
		stack.push("yaseen");
		stack.push("vivek");
		stack.push("gopal");
		stack.push("naga");
		stack.push("ravi");
	}

	@Test
	void testSize() {
		assertEquals(6, stack.size());
	}

	@Test
	void testPush() {
		stack.push("kumar");
		assertEquals("kumar", stack.peek());
		assertEquals(7, stack.size());
	}

	@Test
	void testPop() {
		assertEquals("ravi", stack.pop());
		assertEquals(5, stack.size());
	}

	@Test
	void testPeek() {
		assertEquals("ravi", stack.peek());
		assertEquals(6, stack.size());
	}

	@Test
	void testIsEmpty() {
		while (!stack.isEmpty()) {
			stack.pop();
		}
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
		stack.printAll();
	}

	@Test
	void testContains() {
		stack.printAll();
		assertTrue(stack.contains("sharath"));
	}

}
