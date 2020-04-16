package com.useful.programmes;

import java.util.stream.IntStream;

public class PrimeNumberGenerator {

	public int[] generate(int max) {
		return IntStream.range(2, max)
				        .filter(this::isPrime)
				        .toArray();
	}
	
	public boolean isPrime(int number) {
		return number>1 && IntStream.range(2, (int)Math.sqrt(number))
				                    .noneMatch(i->number%i==0);
	}
	
	public int nextPrimeNumber(int number) {
		return IntStream.iterate(number+1, n->n+1)
		                .filter(this::isPrime)
		                .findFirst()
		                .getAsInt();
	}
}
