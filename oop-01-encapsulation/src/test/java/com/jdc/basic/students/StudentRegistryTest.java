package com.jdc.basic.students;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StudentRegistryTest {
	
	private StudentRegistry registry;
	
	@BeforeEach
	void beforeEach() {
		registry = new StudentRegistry();
	}

	@ParameterizedTest
	@CsvSource(value = {
		"Aung Aung,091818111,aung@gmail.com,1",
		"Maung Maung,,,1",
	})
	void test_add(String name, String phone, String email, int expectedId) {
		
		// Prepare Input
		var input = new Student(name, phone, email);
		
		// Execute Target Method
		var result = registry.add(input);

		// Check Result
		assertEquals(expectedId, result.id());
		assertEquals(name, result.name());
		assertEquals(phone, result.phone());
		assertEquals(email, result.email());
	}
	
	@Test
	void test_getAll() {
		
		// Prepare Inputs
		registry.add(new Student("Thidar", null, null));
		registry.add(new Student("Nilar", null, null));
		registry.add(new Student("Aung Aung", null, null));
		registry.add(new Student("Maung Maung", null, null));
		registry.add(new Student("Tun Tun", null, null));
		
		var students = registry.getAll();
		
		Arrays.sort(students, (a, b) -> a.name().compareTo(b.name()));
		
		assertEquals(1, registry.getAll()[0].id());
		assertEquals("Thidar", registry.getAll()[0].name());
		
		assertEquals(5, students[registry.getAll().length - 1].id());
		assertEquals("Tun Tun", students[registry.getAll().length - 1].name());
	}
}
