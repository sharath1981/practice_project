package com.useful.programmes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonFileReader {

	public List<Person> readPersonFile1(final String filePath) {
		try (final Stream<String> lines = Files.lines(Paths.get(filePath))) {
			return getPersons(lines);
		} catch (IOException e) {
		}
		return Collections.EMPTY_LIST;
	}
	
	public List<Person> readPersonFile2(final String filePath) {
		try (final BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
				final Stream<String> lines = reader.lines()) {
			return getPersons(lines);
		} catch (IOException e) {
		}
		return Collections.EMPTY_LIST;
	}
	
	private List<Person> getPersons(final Stream<String> lines) {
		return lines.map(this::populatePerson)
				    .sorted(Comparator.comparing(Person::getAge))
				    .collect(Collectors.toList());
	}
	
	private Person populatePerson(final String line) {
		String p[] = line.split(",");
		return new Person(p[0], Integer.parseInt(p[1]));
	}

}

class Person {
	private String name;
	private int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, age=%s]", name, age);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
