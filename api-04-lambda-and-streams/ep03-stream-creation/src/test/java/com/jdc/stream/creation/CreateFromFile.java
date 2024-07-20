package com.jdc.stream.creation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class CreateFromFile {

	@Test
	void test() {
		
		try(var stream = Files.lines(Path.of("data", "poem.txt"))) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
