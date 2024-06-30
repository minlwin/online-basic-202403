package com.jdc.generics;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class SubTypingTest {

	@Test
	void test() {
		
		SuperType<Number> superType = new SuperType<Number>();
		assertNotNull(superType);
	}
}
