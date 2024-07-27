package com.jdc.stream.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.jdc.demo.NameAndPrice;
import com.jdc.demo.Product;

public class GroupingBy {

	@Test
	void test_grouping_by() {
		
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			Map<String, List<Product>> result = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.collect(Collectors.groupingBy(Product::category));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	void test_grouping_by_downstream() {
		
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			Map<String, Map<Integer, NameAndPrice>> result = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.collect(Collectors.groupingBy(
						Product::category, 
						Collectors.toMap(Product::id, a -> new NameAndPrice(a.name(), a.price()))));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}	
}
