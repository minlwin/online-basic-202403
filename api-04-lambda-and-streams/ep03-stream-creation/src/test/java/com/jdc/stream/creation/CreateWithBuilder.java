package com.jdc.stream.creation;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class CreateWithBuilder {

	@Test
	void test() {
		
		var stream = Stream.builder()
			.add("Hello")
			.add("Java")
			.add("Spring")
			.add("Hibernate")
			.build();
		
		var list = stream.toList();
		
		System.out.println(list);
	}
}
