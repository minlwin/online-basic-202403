package com.jdc.stream.creation;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class CreateFromITeration {

	@Test
	void test() {
		
		var stream = IntStream.iterate(0, a -> a + 1);
		stream.limit(5).forEach(System.out::println);

		stream = IntStream.iterate(0, a -> a <= 5 ,a -> a + 1);
		stream.forEach(System.out::println);
	}
}
