package com.jdc.io.files;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(value = OrderAnnotation.class)
public class UsingFileObject {

	@Test
	@Order(1)
	void test_create_file_object() {
		
		var desktop = new File("/Users/minlwin/Desktop");
		
		System.out.printf("Desktop is exists : %s%n", desktop.exists());
		
		var certificateFolder = new File(desktop, "certificate");
		System.out.printf("Certificate is exists : %s%n", certificateFolder.exists());
		
		var voucher = new File("/Users/minlwin/Desktop", "voucher");
		System.out.printf("Voucher is exists : %s%n", voucher.exists());
		
		var tempFolder = new File(desktop, "temp");
		System.out.printf("Temp is exists : %s%n", tempFolder.exists());
		
		var dataFolder = new File("data");
		System.out.printf("Data is exists : %s%n", dataFolder.exists());
	}
	
	@Test
	@Order(2)
	void test_create_directories_and_files() throws IOException {
		
		System.out.println("""
				---------------------------
				Create Directory
				---------------------------
				""");
		
		var temp = new File("temp");
		temp.deleteOnExit();
		
		System.out.printf("Temp Folder is exists : %s%n", temp.exists());
		
		// temp/data
		var data = new File(temp, "data");
		System.out.printf("Data Folder is exists : %s%n", data.exists());
		
		var testFile = new File(data, "test.txt");
		System.out.printf("Test File is exists : %s%n", testFile.exists());
		
		var mkdirResult = data.mkdirs();
		
		System.out.printf("Data is created : %s%n", mkdirResult);
		
		var createFileResult = testFile.createNewFile();
		System.out.printf("Test File is created : %s%n", createFileResult);
		
		System.out.printf("Data Folder is exists : %s%n", data.exists());
		System.out.printf("Temp Folder is exists : %s%n", temp.exists());
		System.out.printf("Test File is exists : %s%n", testFile.exists());
		
		mkdirResult = data.mkdir();
		System.out.printf("Data is created : %s%n", mkdirResult);
		
		System.out.printf("Abslute path of test file is %s%n", testFile.getAbsolutePath());
	}
}
