package com.jdc.demo.reflection;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.jdc.demo.usage.domain.Student;
import com.jdc.demo.usage.processor.FieldsValidationException;
import com.jdc.demo.usage.processor.FieldsValidator;

public class FieldsValidatorTest {

	@Test
	void test_no_error() {
		
		// Prepare Input
		var student = new Student();
		student.setName("Aung Aung");
		student.setPhone("0911112222");
		student.setDob(LocalDate.of(2000, 1, 1));
		
		// Execute Target Method
		assertDoesNotThrow(() -> FieldsValidator.validate(student));
	}
	
	@Test
	void test_all_error() {
		
		// Prepare Input
		var student = new Student();
		
		// Execute Target Method
		var exception = assertThrows(FieldsValidationException.class, 
				() -> FieldsValidator.validate(student));
		
		assertEquals(3, exception.getMessages().size());
	}
	
	@Test
	void test_no_name_error() {
		
		// Prepare Input
		var student = new Student();
		student.setPhone("0911112222");
		student.setDob(LocalDate.of(2000, 1, 1));
		
		// Execute Target Method
		var exception = assertThrows(FieldsValidationException.class, 
				() -> FieldsValidator.validate(student));
		
		assertEquals(1, exception.getMessages().size());
	}
	
	@Test
	void test_blank_name_error() {
		
		// Prepare Input
		var student = new Student();
		student.setName("");
		student.setPhone("0911112222");
		student.setDob(LocalDate.of(2000, 1, 1));
		
		// Execute Target Method
		var exception = assertThrows(FieldsValidationException.class, 
				() -> FieldsValidator.validate(student));
		
		assertEquals(1, exception.getMessages().size());
	}	
}
