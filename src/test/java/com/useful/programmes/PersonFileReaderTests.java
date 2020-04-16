package com.useful.programmes;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonFileReaderTests {

	private static String filePath = "D:/my_workspace/practice_project/src/test/resources/persons";
	private PersonFileReader personFileReader;
	@BeforeEach
	void setUp() throws Exception {
		personFileReader = new PersonFileReader();
	}

	@Test
	void testReadPersonFile1() {
		assertIterableEquals(personFileReader.readPersonFile2(filePath), personFileReader.readPersonFile1(filePath));
	}

	@Test
	void testReadPersonFile2() {
		assertIterableEquals(personFileReader.readPersonFile1(filePath), personFileReader.readPersonFile2(filePath));
	}

}
