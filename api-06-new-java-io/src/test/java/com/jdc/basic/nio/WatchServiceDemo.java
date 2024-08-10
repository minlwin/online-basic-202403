package com.jdc.basic.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;

import org.junit.jupiter.api.Test;

public class WatchServiceDemo {

	@Test
	void test() {
		
		try(var watcher = FileSystems.getDefault().newWatchService()) {
			
			System.out.println("""
					================================
					Start Watching
					================================
					""");
			
			var desktop = Path.of(System.getProperty("user.home"), "Desktop");
			var watchKey = desktop.register(watcher, 
					StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY);
			
			var changes = 0;
			
			while(changes < 5) {
				
				var events = watchKey.pollEvents();
				
				for(var event : events) {
					if(event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE) 
							&& event.context() instanceof Path newPath) {
						
						System.out.printf("Created File Name -> %s%n", newPath.toString());
					}
					
					if(event.kind().equals(StandardWatchEventKinds.ENTRY_MODIFY) 
							&& event.context() instanceof Path newPath) {
						
						System.out.printf("Updated File Name -> %s%n", newPath.toString());
						
						var lines = Files.readAllLines(desktop.resolve(newPath));
						for(var line : lines) {
							System.out.println(line);
						}
					}
					
					changes ++;
				}
			}
			System.out.println("""
					================================
					End Watching
					================================
					""");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
