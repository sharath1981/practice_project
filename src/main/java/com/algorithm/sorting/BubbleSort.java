/**
 * 
 */
package com.algorithm.sorting;

/**
 * @author Sharath Kumar B <sharath1981@gmail.com>
 *
 */
public class BubbleSort {

	private final int[] arr;

	public BubbleSort(int[] arr) {
		this.arr = arr;
	}

	public void sort() {
		final int maxIndex = arr.length - 1;
		for (int i = 0; i < maxIndex; i++) {
			for (int j = 0; j < maxIndex - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j);
				}
			}
		}
	}

	private void swap(int[] arr, int i) {
		int temp = arr[i];
		arr[i] = arr[i + 1];
		arr[i + 1] = temp;
	}
}
