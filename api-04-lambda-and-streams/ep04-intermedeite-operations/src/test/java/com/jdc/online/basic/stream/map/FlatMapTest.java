package com.jdc.online.basic.stream.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class FlatMapTest {

	@Test
	void test_flat_map() {
		
		var productDir = Path.of("data", "product");
		
		try(var stream1 = Files.lines(productDir.resolve("product1.txt"));
				var stream2 = Files.lines(productDir.resolve("product2.txt"))) {
			
			Stream<Stream<String>> streams = Stream.of(stream1, stream2);
			
			streams.flatMap(stream -> stream)
				.map(line -> line.split("\t"))
				.filter(array -> array.length == 3)
				.map(array -> new Product(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2])))
				.forEach(product -> System.out.println(product));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
