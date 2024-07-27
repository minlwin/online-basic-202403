package com.jdc.stream.terminal;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class IterationDemo {

	@Test
	void test_for_each_sequential() {
		
		System.out.println("For Each Sequential");
		
		Stream.iterate(1, a -> a <= 20, a -> a + 1)
			.forEach(a -> System.out.println(a));
	}

	@Test
	void test_for_each_parallel() {
		
		System.out.println("For Each Parallel");
		
		Stream.iterate(1, a -> a <= 20, a -> a + 1)
			.parallel()
			.forEach(a -> System.out.println(a));
	}
	
	@Test
	void test_for_each_ordered() {
		
		System.out.println("For Each Ordered Parallel");
		
		Stream.iterate(1, a -> a <= 20, a -> a + 1)
			.parallel()
			.forEachOrdered(a -> System.out.println(a));
	}
	
}
