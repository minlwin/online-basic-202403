package com.jdc.lambda.demo;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BeforeAndAfterTest {

	@ParameterizedTest
	@MethodSource("test_data")
	void test_before(List<Integer> list) {
		
		BeforeAndAfter.before(list);
	}
	
	static Stream<Arguments> test_data() {
		return Stream.of(
			Arguments.of(List.of(1, 2, 3, 4, 5))
		);
	}
}
