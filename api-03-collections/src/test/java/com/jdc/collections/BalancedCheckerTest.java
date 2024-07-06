package com.jdc.collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BalancedCheckerTest {
	
	private BalancedChecker checker = new BalancedChecker();
	
	@ParameterizedTest
	@ValueSource(strings = {
		"[]",
		"()",
		"{}",
		"[](){}",
		"[()]{([])}"
	})
	void test_true(String value) {
		assertTrue(checker.isBalance(value));
	}

	@ParameterizedTest
	@ValueSource(strings = {
		"[",
		"()[",
		"",
		"[]((){}",
		"[()]){([])}"
	})
	void test_false(String value) {
		assertFalse(checker.isBalance(value));
	}
}
