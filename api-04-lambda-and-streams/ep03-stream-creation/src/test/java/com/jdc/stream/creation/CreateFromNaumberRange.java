package com.jdc.stream.creation;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class CreateFromNaumberRange {

	@Test
	void test() {
		
		var stream = IntStream.rangeClosed(1, 20);
		
		stream.forEach(System.out::println);
	}
}
