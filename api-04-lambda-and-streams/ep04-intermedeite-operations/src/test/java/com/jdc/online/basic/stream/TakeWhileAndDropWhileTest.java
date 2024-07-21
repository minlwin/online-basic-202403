package com.jdc.online.basic.stream;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class TakeWhileAndDropWhileTest {

	@Test
	void test_take_while() {
		System.out.println("Take While");
		IntStream.iterate(1, a -> a + 1)
				.takeWhile(a -> a <= 10)
				.forEach(System.out::println);
	}
	
	@Test
	void test_drop_while() {
		System.out.println("Drop While");
		IntStream.iterate(1, a -> a + 1)
			.dropWhile(a -> a < 10)
			.limit(10)
			.forEach(System.out::println);
	}
	
}
