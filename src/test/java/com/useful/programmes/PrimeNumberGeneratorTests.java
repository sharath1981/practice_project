package com.useful.programmes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrimeNumberGeneratorTests {

	private PrimeNumberGenerator generator;
	
	@BeforeEach
	void setUp() throws Exception {
		generator = new PrimeNumberGenerator();
	}

	@Test
	void testGenerate() {
		assertArrayEquals(new int[] {2, 3, 4, 5, 6, 7, 8, 9}, generator.generate(10));
	}

	@Test
	void testIsPrime() {
		assertTrue(generator.isPrime(2));
		assertTrue(generator.isPrime(31));
		assertFalse(generator.isPrime(1));
	}
	
	@Test
	void TestNextPrimeNuber() {
		assertEquals(121, generator.nextPrimeNumber(113));
	}

}
