package com.jdc.online.basic.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class FilteringStreamTest {

	@Test
	void test_int_stream() {
		
		var stream = IntStream.iterate(1, a -> a + 1)
				.limit(30);
		
		stream.filter(a -> a % 3 == 0)
			.forEach(a -> System.out.println(a));
	}
	
	@Test
	void test_generic_stream() {
		var stream = Stream.of(
				"Java", "Spring", "JPA", "Spring MVC", "Spring Data Jpa"
				);
		
		stream.filter(a -> a.toLowerCase().contains("spring"))
			.forEach(System.out::println);
		
	}
}
