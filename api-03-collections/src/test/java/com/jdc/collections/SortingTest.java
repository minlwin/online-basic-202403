package com.jdc.collections;

import static java.time.DayOfWeek.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SortingTest {

	@ParameterizedTest
	@MethodSource("test_sorting_array_string_data")
	void test_sorting_array_string(String[] input, String[] output) {
		Arrays.sort(input);
		var result = Arrays.equals(input, input);
		assertTrue(result);
	}
	
	static Stream<Arguments> test_sorting_array_string_data() {
		return Stream.of(
			Arguments.of(new String[] {"C", "B", "A"}, new String[] {"A", "B", "C"}),
			Arguments.of(new String[] {"your name", "is", "aung aung"}, new String[] {"aung aung", "is", "your name"})
		);
	}
	
	@ParameterizedTest
	@MethodSource("test_sorting_enum_list_data")
	void test_sorting_enum_list(List<DayOfWeek> input, List<DayOfWeek> output) {
		Collections.sort(input);
		var result = input.equals(output);
		assertTrue(result);
	}
	
	static Stream<Arguments> test_sorting_enum_list_data() {
		return Stream.of(
			Arguments.of(
				new ArrayList<DayOfWeek>(List.of(SUNDAY, THURSDAY, FRIDAY, MONDAY, SATURDAY)),
				new ArrayList<DayOfWeek>(List.of(MONDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY))
			)
		);
	}
	
	@ParameterizedTest
	@MethodSource("test_sorting_custome_object")
	void test_sorting_custome_object(Product[] input, Product[] output) {
		Arrays.sort(input);
		var result = Arrays.equals(input, output);
		assertTrue(result);
	}

	static Stream<Arguments> test_sorting_custome_object() {
		return Stream.of(
			Arguments.of(
				new Product[] {
					new Product(3, "Coke"),
					new Product(9, "Pepsi"),
					new Product(5, "7Up"),
					new Product(2, "Vcode")
				},
				new Product[] {
					new Product(2, "Vcode"),
					new Product(3, "Coke"),
					new Product(5, "7Up"),
					new Product(9, "Pepsi")
				}
			)
		);
	}
	
	@ParameterizedTest
	@MethodSource("test_sorting_desc_data")
	void test_sorting_desc(List<Product> input, List<Product> output) {
		
		Comparator<Product> desc = new Comparator<Product>() {
			
			@Override
			public int compare(Product o1, Product o2) {
				return o2.id() - o1.id();
			}
		};
		
		Collections.sort(input, desc);
		System.out.println(input);
		
		var result = input.equals(output);
		assertTrue(result);
	}
	
	static Stream<Arguments> test_sorting_desc_data() {
		return Stream.of(
			Arguments.of(getInput(), getOutput())
		);
	}

	private static List<Product> getOutput() {
		var list = new ArrayList<Product>();
		list.add(new Product(9, "Pepsi"));
		list.add(new Product(5, "7Up"));
		list.add(new Product(3, "Coke"));
		list.add(new Product(2, "Vcode"));
		return list;
	}

	private static List<Product> getInput() {
		var list = new ArrayList<Product>();
		list.add(new Product(3, "Coke"));
		list.add(new Product(9, "Pepsi"));
		list.add(new Product(5, "7Up"));
		list.add(new Product(2, "Vcode"));
		return list;
	}
}
