package com.jdc.basic.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class FileSystemTest {

	@Test
	void test_default() {
		
		var fs = FileSystems.getDefault();
		fs.getFileStores().forEach(store -> {
			try {
				System.out.printf("Name   : %s%n", store.name());
				System.out.printf("Total  : %s%n", store.getTotalSpace());
				System.out.printf("Usable : %s%n", store.getUsableSpace());
			} catch (Exception e) {
				e.printStackTrace();
			}		
		});
		
		fs.getRootDirectories().forEach(root -> {
			System.out.printf("Root -> %s%n", root);
		});
	}
	
	@Test
	void test_virtual_fs() throws IOException {
		var zipFile = FileSystems.newFileSystem(Path.of("kafka-demo.zip"));
		zipFile.getRootDirectories().forEach(root -> {
			try(var stream = Files.list(root)) {
				
				stream.forEach(path -> {
					System.out.println(path);
					try(var children = Files.list(path)) {
						children.forEach(System.out::println);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
