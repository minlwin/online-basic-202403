package com.jdc.stream.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import com.jdc.demo.Product;

public class GetSingleResult {

	@Test
	void test_max() {
		
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var product = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.max((a, b) -> a.price() - b.price());
			
			product.ifPresent(a -> System.out.println(a));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void test_min() {
		
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var product = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.min((a, b) -> a.price() - b.price());
			
			System.out.println(product);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_find_first() {
		
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var product = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.filter(a -> a.price() < 1000)
				.findFirst();
			
			System.out.println(product);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_find_any() {
		
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var product = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.findAny();
			
			System.out.println(product);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
