package com.algorithm.searching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTests {

	private String[] input1;
	private Integer[] input2;
	
	@BeforeEach
	void setUp() throws Exception {
		input1 = new String[] {"A", "B", "C", "D", "E", "F"};
		input2 = new Integer[] {1, 2, 3, 4, 5, 6};
	}

	@Test
	void testSearchIterative() {
		assertEquals(3, BinarySearch.searchIterative(input1,  "D", 0, input1.length - 1));
		assertEquals(0, BinarySearch.searchIterative(input1,  "A", 0, input1.length - 1));
		assertEquals(5, BinarySearch.searchIterative(input1,  "F", 0, input1.length - 1));
		assertEquals(3, BinarySearch.searchIterative(input2,  4, 0, input2.length - 1));
		assertEquals(0, BinarySearch.searchIterative(input2,  1, 0, input2.length - 1));
		assertEquals(5, BinarySearch.searchIterative(input2,  6, 0, input2.length - 1));
		assertEquals(4, BinarySearch.searchIterative(input2,  5, 0, input2.length - 1));
		assertEquals(1, BinarySearch.searchIterative(input2,  2, 0, input2.length - 1));
		assertEquals(2, BinarySearch.searchIterative(input2,  3, 0, input2.length - 1));
	}
	
	@Test
	void testSearchRecursive() {
		assertEquals(3, BinarySearch.searchRecursive(input1,  "D", 0, input1.length - 1));
		assertEquals(0, BinarySearch.searchRecursive(input1,  "A", 0, input1.length - 1));
		assertEquals(5, BinarySearch.searchRecursive(input1,  "F", 0, input1.length - 1));
		assertEquals(3, BinarySearch.searchRecursive(input2,  4, 0, input2.length - 1));
		assertEquals(0, BinarySearch.searchRecursive(input2,  1, 0, input2.length - 1));
		assertEquals(5, BinarySearch.searchRecursive(input2,  6, 0, input2.length - 1));
		assertEquals(4, BinarySearch.searchRecursive(input2,  5, 0, input2.length - 1));
		assertEquals(1, BinarySearch.searchRecursive(input2,  2, 0, input2.length - 1));
		assertEquals(2, BinarySearch.searchRecursive(input2,  3, 0, input2.length - 1));
	}

}
