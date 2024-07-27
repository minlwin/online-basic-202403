package com.jdc.stream.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import com.jdc.demo.Product;

public class SpecificStreamSummary {

	@Test
	void test_max() {
		
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var result = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.mapToInt(Product::price)
				.sum();
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_average() {
		
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var result = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.mapToInt(Product::price)
				.average();
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_summary() {
		
		try(var stream = Files.lines(Path.of("data", "product1.txt"))) {
			
			var result = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.mapToInt(Product::price)
				.summaryStatistics();
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
