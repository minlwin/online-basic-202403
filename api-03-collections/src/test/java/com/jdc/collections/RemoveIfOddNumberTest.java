package com.jdc.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RemoveIfOddNumberTest {

	private RemoveIfOddNumber remove;
	
	@BeforeEach
	void init() {
		remove = new RemoveIfOddNumber();
	}
	
	@ParameterizedTest
	@MethodSource("removeTestArguments")
	void test(List<Integer> input, List<Integer> output) {
		var result = remove.removeIfOdd(input);
		
		assertNotNull(result);
		assertEquals(output.size(), result.size());
		
		for(var i = 0; i < output.size(); i ++) {
			assertEquals(output.get(i), result.get(i));
		}
	}
	
	static Stream<Arguments> removeTestArguments() {
		return Stream.of(
			Arguments.of(new ArrayList<>(List.of(1, 2, 3, 4, 5)), List.of(2, 4)),
			Arguments.of(new ArrayList<>(List.of(1,3,5,7,9)), List.of()),
			Arguments.of(new ArrayList<>(List.of(2,4,6,8)), List.of(2,4,6,8))
		);
	}
}
