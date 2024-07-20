package com.jdc.stream.creation;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CreateFromCollectionsAndArrays {

	@Test
	void test_create_from_collection() {
		
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		list.parallelStream().forEachOrdered(System.out::println);
	}
	
	@Test
	void test_create_from_array() {
		
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		var sum = Arrays.stream(array).sum();
		System.out.println(sum);
	}
}
