package com.jdc.basic.nio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileCopyServiceTest {
	
	private FileCopyService service;
	
	@BeforeEach
	void beforeEach() {
		service = new FileCopyService();
	}

	@Test
	void test_copy() {
		var source = "%s/Desktop/source.mp4".formatted(System.getProperty("user.home"));
		var destination = "%s/Desktop/target.mp4".formatted(System.getProperty("user.home"));
	
		service.copy(source, destination);
	}

	@Test
	void test_transfer() {
		var source = "%s/Desktop/source.mp4".formatted(System.getProperty("user.home"));
		var destination = "%s/Desktop/transfer-target.mp4".formatted(System.getProperty("user.home"));
	
		service.transfer(source, destination);
	}
}
