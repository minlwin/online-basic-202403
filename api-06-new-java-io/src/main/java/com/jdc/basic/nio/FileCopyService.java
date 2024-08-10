package com.jdc.basic.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileCopyService {

	
	public void copy(String source, String destination) {
		
		try(var input = Files.newByteChannel(Path.of(source), StandardOpenOption.READ);
				var output = Files.newByteChannel(Path.of(destination), 
						StandardOpenOption.WRITE,
						StandardOpenOption.CREATE,
						StandardOpenOption.TRUNCATE_EXISTING)) {
			
			var buffer = ByteBuffer.allocate(1024);
			
			while(input.read(buffer) > -1) {
				buffer.flip();
				output.write(buffer);
				buffer.clear();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void transfer(String source, String destination) {
		
		try(var input = FileChannel.open(Path.of(source), StandardOpenOption.READ);
				var output = FileChannel.open(Path.of(destination), 
						StandardOpenOption.WRITE,
						StandardOpenOption.CREATE,
						StandardOpenOption.TRUNCATE_EXISTING)) {
			
			input.transferTo(0, input.size(), output);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
