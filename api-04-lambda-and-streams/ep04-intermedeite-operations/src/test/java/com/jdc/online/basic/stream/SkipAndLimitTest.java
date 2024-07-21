package com.jdc.online.basic.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SkipAndLimitTest {

	@Disabled
	@Test
	void test_skip() {
		
		try(var stream = Files.lines(Path.of("data", "poem.txt"))) {
			
			stream.skip(7)
				.forEach(System.out::println);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Disabled
	@Test
	void test_limit() {
		
		try(var stream = Files.lines(Path.of("data", "poem.txt"))) {
			
			stream.limit(7)
				.forEach(System.out::println);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_skip_and_limit() {
		try(var stream = Files.lines(Path.of("data", "poem.txt"))) {
			
			stream.skip(7)
				.limit(5)
				.forEach(System.out::println);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
