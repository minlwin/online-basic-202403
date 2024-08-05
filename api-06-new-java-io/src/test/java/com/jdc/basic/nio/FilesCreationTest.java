package com.jdc.basic.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(value = OrderAnnotation.class)
public class FilesCreationTest {

	@Test
	@Order(1)
	void test_create_directory() throws IOException {
		
		var parent = Path.of("parent");
		var child = parent.resolve("child");
		
		Files.createDirectories(child);
		
		
		var tempDir = Files.createTempDirectory("test");
		System.out.println(tempDir.toAbsolutePath());
	}
	
	@Test
	@Order(2)
	void test_create_file() throws IOException {
		
		var child = Path.of("parent", "child");
		
		var testFile = child.resolve("test.txt");
		
		if(Files.exists(testFile)) {
			Files.delete(testFile);
		}
		
		Files.createFile(testFile);
		
		var tempFile = Files.createTempFile("temp_", ".txt");
		System.out.println(tempFile);
		
	}
	
	@Test
	@Order(3)
	void test_create_link() throws IOException {
		var child = Path.of("parent", "child");
		
		var link = Files.createSymbolicLink(Path.of("linkToChild"), child);
		System.out.println(link);
	}
}
