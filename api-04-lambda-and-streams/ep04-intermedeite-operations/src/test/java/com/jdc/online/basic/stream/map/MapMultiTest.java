package com.jdc.online.basic.stream.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class MapMultiTest {

	@Test
	void test_map_multi() {
		var productDir = Path.of("data", "product");
		
		try(var stream1 = Files.lines(productDir.resolve("product1.txt"));
				var stream2 = Files.lines(productDir.resolve("product2.txt"))) {
			
			Stream<Stream<String>> streams = Stream.of(stream1, stream2);
			
			streams.flatMap(stream -> stream)
				.map(line -> line.split("\t"))
				.filter(array -> array.length == 3)
				.mapMulti((String[] array, Consumer<Product> consumer) -> {
					var product = new Product(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2]));
					
					if(product.price() < 100_000 && product.price() > 1000) {
						consumer.accept(product);
					}
				})
				.peek(product -> {
					System.out.println(product.price());
				})
				.forEach(product -> System.out.println(product));

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
