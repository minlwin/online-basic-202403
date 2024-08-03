package com.jdc.basic.nio;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class UsingPathDemo {

	@Test
	void test_path_info() {
		System.out.println("""
				-------------------
				Path Info
				-------------------
				""");
		
		var src = Path.of("src");
		System.out.printf("isAbsolute : %s%n", src.isAbsolute());
		System.out.printf("getFileName : %s%n", src.getFileName());
		System.out.printf("getParent : %s%n", src.getParent());
		System.out.printf("getRoot : %s%n", src.getRoot());
		
		src.forEach(path -> System.out.println(path));
		
	}
	
	@Test
	void test_to_absoute() {
		System.out.println("""
				---------------------
				Path Info of Absolute
				---------------------
				""");
		
		var src = Path.of("src").toAbsolutePath();
		System.out.printf("isAbsolute : %s%n", src.isAbsolute());
		System.out.printf("getFileName : %s%n", src.getFileName());
		System.out.printf("getParent : %s%n", src.getParent());
		System.out.printf("getRoot : %s%n", src.getRoot());
		
		src.forEach(path -> System.out.println(path));	
	}
	
	@Test
	void test_to_normalize() {
		System.out.println("""
				---------------------
				Normalizing Path
				---------------------
				""");
		
		var path = Path.of("./src/../src/../src");
		System.out.println(path);
		
		var normalForm = path.normalize();
		System.out.println(normalForm);
		
		var child = normalForm.resolve("hello");
		System.out.println(child);
		
		var sibling = normalForm.resolveSibling("brother");
		System.out.println(sibling);
		
	}
}
