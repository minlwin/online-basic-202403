package com.jdc.stream.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.jdc.demo.Product;

public class ReducingResult {

	@Test
	void test_reducing() {
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var result = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.map(Product::price)
				.reduce(0, (a, b) -> a + b);
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	void test_reducing_without_identity() {
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var result = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.map(Product::price)
				.reduce((a, b) -> a + b);
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	void test_reduce_to_other_types() {
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var result = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.map(Product::price)
				.reduce(
					new ArrayList<Integer>(),
					(list, price) -> {
						list.add(price);
						return list;
					},
					(left, right) -> {
						left.addAll(right);
						return left;
					}
				);
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
