package com.jdc.stream.terminal;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalDemo {

	@Test
	void test_optional() {
		
		var optional = Optional.ofNullable("Some Data");
		optional.filter(s -> s.startsWith("a"))
			.map(a -> a.toUpperCase())
			.ifPresent(System.out::println);
	}
}
