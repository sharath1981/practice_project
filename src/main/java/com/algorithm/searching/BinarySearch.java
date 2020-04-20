package com.algorithm.searching;

public class BinarySearch {
	public static <E extends Comparable<E>> int searchIterative(E[] input, E element, int start, int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (input[mid].compareTo(element) == 0) {
				return mid;
			}
			if (input[mid].compareTo(element) < 0) {
				start = mid + 1;
			}
			if (input[mid].compareTo(element) > 0) {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static <E extends Comparable<E>> int searchRecursive(E[] input, E element, int start, int end) {
		if (start <= end) {
			int mid = start + (end - start) / 2;
			if (input[mid].compareTo(element) == 0) {
				return mid;
			}
			if (input[mid].compareTo(element) < 0) {
				return searchRecursive(input, element, mid + 1, end);
			}
			if (input[mid].compareTo(element) > 0) {
				return searchRecursive(input, element, start, mid - 1);
			}
		}
		return -1;
	}
}
