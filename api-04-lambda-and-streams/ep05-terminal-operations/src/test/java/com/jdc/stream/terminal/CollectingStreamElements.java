package com.jdc.stream.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.jdc.demo.Product;

public class CollectingStreamElements {

	@Test
	void test_to_collection() {
		
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var result = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.collect(Collectors.toCollection(() -> new TreeSet<>()));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_to_map() {
		
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var result = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.collect(Collectors.toMap(Product::id, Function.identity()));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_joing_string() {
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var result = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.map(Product::name)
				.collect(Collectors.joining(","));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
