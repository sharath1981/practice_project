package com.useful.programmes;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LargestNonOccuringPositiveNumber {

	public static void main(String[] args) {
		System.out.println(find(new int[]{3,3,1,1,1,1,2,2,2,2}));

	}
	
	private static int find(int[] arr) {
		return IntStream.rangeClosed(1, arr.length)
						.filter(i->Arrays.stream(arr).noneMatch(x->x==i))
						.findFirst()
						.orElse(1);
	}

}