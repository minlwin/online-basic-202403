package com.jdc.io.files;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.io.demo.FileCopier;

public class FileCopierTest {
	
	private FileCopier copier;
	
	@BeforeEach
	void init() {
		copier = new FileCopier();
	}

	@Test
	void test_copy_file() {
		var original = new File("original", "generics.pdf");
		assertTrue(original.exists());
		
		var copy = new File("copy", "generics.pdf");
		copy.delete();
		assertFalse(copy.exists());
		
		var result = copier.copy(original, copy);
		assertTrue(result);
		
		assertTrue(copy.exists());
	}
}
