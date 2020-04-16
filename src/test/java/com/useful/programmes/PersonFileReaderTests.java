package com.useful.programmes;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Comparator;
import java.util.function.Predicate;

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
		Predicate<Person> filter = p -> p.getAge()<39;
		Comparator<Person> comparing = Comparator.comparing(Person::getAge);
		assertIterableEquals(personFileReader.readPersonFile2(filePath, filter, comparing), 
				personFileReader.readPersonFile1(filePath, filter, comparing));
		personFileReader.readPersonFile1(filePath, filter.negate(), comparing.reversed()).forEach(System.out::println);
		
	}

	@Test
	void testReadPersonFile2() {
		Predicate<Person> filter = p -> p.getAge()<35;
		Comparator<Person> comparing = Comparator.comparing(Person::getName);
		assertIterableEquals(personFileReader.readPersonFile1(filePath, filter, comparing), 
				personFileReader.readPersonFile2(filePath, filter, comparing));
		personFileReader.readPersonFile2(filePath, filter, comparing).forEach(System.out::println);
	}

}
