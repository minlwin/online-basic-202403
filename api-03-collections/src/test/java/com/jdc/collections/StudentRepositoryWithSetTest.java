package com.jdc.collections;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.collections.Student.Gender;

@TestMethodOrder(value = OrderAnnotation.class)
public class StudentRepositoryWithSetTest {

	private static StudentRepository repo;
	
	@BeforeAll
	static void beforeAll() {
		repo = new StudentRepositoryWithSet();
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvFileSource(resources = "/data/add-error.txt", delimiterString = "\t")
	void test_add_error(String name, LocalDate dob, Gender gender, String phone, String email, int errorCount) {
		
		var student = new Student(0, name, dob, gender, phone, email);
		
		var exception = assertThrows(BusinessException.class, () -> {
			repo.add(student);
		});
		
		assertEquals(errorCount, exception.getMessages().size());
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvFileSource(resources = "/data/add-success.txt", delimiterString = "\t")
	void test_add_success(String name, LocalDate dob, Gender gender, String phone, String email, int id) {

		var student = new Student(0, name, dob, gender, phone, email);
		
		assertDoesNotThrow(() -> {
			var result = repo.add(student);
			assertEquals(id, result);
		});
	}
	
	@Order(3)
	@Test
	void test_get_all() {
		var result = repo.getAll();
		assertEquals(5, result.size());
	}
	
	@Order(4)
	@ParameterizedTest
	@CsvFileSource(resources = "/data/add-success.txt", delimiterString = "\t")
	void test_find_by_id_found(String name, LocalDate dob, Gender gender, String phone, String email, int id) {
		
		var student = repo.findById(id);
		
		assertNotNull(student);
		assertEquals(id, student.id());
		assertEquals(name, student.name());
		assertEquals(dob, student.dob());
		assertEquals(gender, student.gender());
		assertEquals(phone, student.phone());
		assertEquals(email, student.email());
	}
	
	@Order(5)
	@ParameterizedTest
	@ValueSource(ints = {0, 6})
	void test_find_by_id_not_found(int id) {
		assertNull(repo.findById(id));
	}
	
	@Order(6)
	@ParameterizedTest
	@CsvFileSource(resources = "/data/update-error.txt", delimiterString = "\t")
	void test_update_error(int id, String name, LocalDate dob, Gender gender, String phone, String email, int errorCount) {
		var student = new Student(id, name, dob, gender, phone, email);
		
		var exception = assertThrows(BusinessException.class, () -> {
			repo.update(student);
		});
		
		assertEquals(errorCount, exception.getMessages().size());
	}

	@Order(7)
	@ParameterizedTest
	@CsvFileSource(resources = "/data/update-found.txt", delimiterString = "\t")
	void test_update_found(int id, String name, LocalDate dob, Gender gender, String phone, String email) {
		var student = new Student(id, name, dob, gender, phone, email);
		
		assertDoesNotThrow(() -> {
			assertTrue(repo.update(student));
		});
	}
	
	@Order(8)
	@ParameterizedTest
	@CsvFileSource(resources = "/data/update-not-found.txt", delimiterString = "\t")
	void test_update_not_found(int id, String name, LocalDate dob, Gender gender, String phone, String email) {
		var student = new Student(id, name, dob, gender, phone, email);
		
		assertDoesNotThrow(() -> {
			assertFalse(repo.update(student));
		});
	}
	
	@Order(9)
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void test_delete_found(int id) {
		assertTrue(repo.delete(id));
	}
	
	@Order(10)
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void test_delete_not_found(int id) {
		assertFalse(repo.delete(id));
	}
}
