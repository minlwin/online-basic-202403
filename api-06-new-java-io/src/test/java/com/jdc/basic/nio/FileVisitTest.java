package com.jdc.basic.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class FileVisitTest {

	@Disabled
	@Test
	void test_walk() throws IOException {
		
		var path = Path.of("kafka-demo.zip");
		
		var fs = FileSystems.newFileSystem(path);
		
		var kafka = fs.getPath("/kafka-demo");
		
		Files.walk(kafka, 3).forEach(file -> System.out.println(file));
	}
	
	@Test
	void test_walk_tree() throws IOException {
		var path = Path.of("kafka-demo.zip");
		
		var fs = FileSystems.newFileSystem(path);
		
		var kafka = fs.getPath("/kafka-demo");
		
		Files.walkFileTree(kafka, new FileNamePrintVisitor());
		
	}
	
	static class FileNamePrintVisitor extends SimpleFileVisitor<Path> {
		
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			System.out.println(dir);
			return FileVisitResult.CONTINUE;
		}
		
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			System.out.println(file);
			return FileVisitResult.CONTINUE;
		}
	}
}
