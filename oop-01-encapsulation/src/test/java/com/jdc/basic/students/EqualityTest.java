package com.jdc.basic.students;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EqualityTest {

	@Test
	void test_equal() {
		
		var student1 = new Student(1, "Aung Aung", "09782002093", "aung@gmail.com");
		var student2 = new Student(1, "Aung Aung", "09782002093", "aung@gmail.com");
		
		System.out.println(student1);
		System.out.println(student2);
		
		assertEquals(student1, student2);
	}
}
