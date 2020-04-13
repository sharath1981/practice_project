package com.algorithm.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BubbleSortTests {

	private BubbleSort bubble;
	private final int[] arr = new int[] { 3, 5, 7, 1, 4, 2, 6 };

	@BeforeEach
	void setUp() throws Exception {
		bubble = new BubbleSort(arr);
	}

	@Test
	void testSort() {
		assertArrayEquals(new int[] { 3, 5, 7, 1, 4, 2, 6 }, arr);
		bubble.sort();
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7 }, arr);
	}

}
