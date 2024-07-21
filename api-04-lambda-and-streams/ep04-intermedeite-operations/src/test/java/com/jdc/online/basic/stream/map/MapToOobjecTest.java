package com.jdc.online.basic.stream.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class MapToOobjecTest {

	@Test
	void test_map() {
		
		try(var stream = Files.lines(Path.of("data", "product", "product1.txt"))) {
			
			stream.map(line -> line.split("\t"))
				.map(array -> new Product(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2])))
				.filter(product -> product.price() < 100_000)
				.forEach(product -> System.out.println(product));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
