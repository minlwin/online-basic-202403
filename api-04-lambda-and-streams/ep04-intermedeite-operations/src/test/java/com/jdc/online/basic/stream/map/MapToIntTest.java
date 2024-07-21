package com.jdc.online.basic.stream.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class MapToIntTest {

	@Test
	void test_map_to_int() {
		try(var stream = Files.lines(Path.of("data", "product", "product1.txt"))) {
			
			var priceTotal = stream.map(line -> line.split("\t"))
				.map(array -> new Product(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2])))
				.mapToInt(product -> product.price())
				.sum();
			
			System.out.println(priceTotal);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
