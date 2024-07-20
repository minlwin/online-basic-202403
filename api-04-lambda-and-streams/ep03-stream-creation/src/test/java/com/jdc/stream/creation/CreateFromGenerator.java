package com.jdc.stream.creation;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class CreateFromGenerator {

	@Test
	void test() {
		
		var random = ThreadLocalRandom.current();
		
		var stream = Stream.generate(() -> random.nextInt(0, 9999));
		
		var list = stream.limit(5)
				.map(a -> "%04d".formatted(a))
				.toList();
		
		System.out.println(list);
	}
}
