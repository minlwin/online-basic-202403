package com.jdc.stream.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import com.jdc.demo.Product;

public class GetMultipleResults {

	@Test
	void test_to_list() {
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var product = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.filter(a -> a.price() > 10_000 && a.price() < 50_000)
				.map(Product::name)
				.sorted()
				.toList();
			
			System.out.println(product);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void test_to_array() {
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var product = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.filter(a -> a.price() > 10_000 && a.price() < 50_000)
				.map(Product::name)
				.sorted()
				.toArray(size -> new String[size]);
			
			System.out.println(product);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
