package com.jdc.basic.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class FilesCopyTest {

	@Test
	void test() throws IOException {
		
		var userHome = Path.of(System.getProperty("user.home"));
		var document = userHome.resolve("Documents");
		var jarFile = document.resolve("mysql-connector-java-8.0.30.jar");
		
		var currentDir = Path.of("./");
		
		Files.copy(jarFile, currentDir.resolve("mysql.jar"));
	}
}
