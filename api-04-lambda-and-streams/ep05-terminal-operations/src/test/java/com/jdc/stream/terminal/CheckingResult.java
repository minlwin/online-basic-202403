package com.jdc.stream.terminal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class CheckingResult {

	@Test
	void test_all_match() {
		
		var result = Stream.of(1, 2, 3, 4, 5)
			.allMatch(a -> a <= 5);
		
		assertTrue(result);
		
		result = Stream.of(1, 2, 3, 4, 5)
				.allMatch(a -> a < 5);
		
		assertFalse(result);
	}
	
	@Test
	void test_any_match() {
		var result = Stream.of(1, 2, 3, 4, 5)
				.anyMatch(a -> a >= 5);
		
		assertTrue(result);
		
		result = Stream.of(1, 2, 3, 4, 5)
				.anyMatch(a -> a > 5);
		
		assertFalse(result);
	}
	
	@Test
	void test_none_match() {
		var result = Stream.of(1, 2, 3, 4, 5)
				.noneMatch(a -> a > 5);
		
		assertTrue(result);
		
		result = Stream.of(1, 2, 3, 4, 5)
				.noneMatch(a -> a >= 5);
		
		assertFalse(result);
	}
}
