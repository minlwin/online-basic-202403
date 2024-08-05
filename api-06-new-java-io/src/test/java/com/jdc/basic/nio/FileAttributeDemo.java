package com.jdc.basic.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;

public class FileAttributeDemo {

	@Test
	void test() throws IOException {
		
		var file = Path.of("mysql.jar");
		
		var owner = Files.getOwner(file);
		System.out.println(owner);
		
		var lastModifiedTime = Files.getLastModifiedTime(file);
		System.out.println(lastModifiedTime);
		
		var lastFiveDay = LocalDateTime.now()
				.minusDays(5)
				.atZone(ZoneId.systemDefault())
				.toInstant();
		
		Files.setLastModifiedTime(file, FileTime.from(lastFiveDay));
		
		lastModifiedTime = Files.getLastModifiedTime(file);
		System.out.println(lastModifiedTime);
		
		var permissions = Files.getPosixFilePermissions(file);
		
		System.out.println(permissions);
		permissions.add(PosixFilePermission.GROUP_WRITE);
		Files.setPosixFilePermissions(file, permissions);
		
		var attributes = Files.readAttributes(file, PosixFileAttributes.class);
		System.out.println(attributes);
	}
}
