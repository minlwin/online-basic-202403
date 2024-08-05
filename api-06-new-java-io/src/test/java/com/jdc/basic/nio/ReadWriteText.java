package com.jdc.basic.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class ReadWriteText {

	@Test
	void test() throws IOException {
		
		var file = Path.of("parent", "child", "test.txt");
		
		var lines = Files.readAllLines(file);
		
		var allLine = lines.stream()
				.collect(Collectors.joining("\n"));
		
		Files.writeString(Path.of("copy.txt"), allLine, StandardOpenOption.CREATE);
	}
}
