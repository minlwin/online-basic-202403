package com.jdc.basic.nio;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ScanAndWriteService {
	
	private String destination;
	private Scanner scanner;
	
	public static void main(String[] args) {
		new ScanAndWriteService("scan-and-write.txt").launch();
	}

	public ScanAndWriteService(String destination) {
		super();
		this.destination = destination;
		this.scanner = new Scanner(System.in);
	}
	
	public void launch() {
		System.out.println("""
				=========================
				Scan & Write Demo
				=========================
				""");
		
		while(true) {
			
			System.out.print("Enter > ");
			var message = scanner.nextLine();
			
			if(null == message || message.isEmpty()) {
				break;
			}
			
			write(message);
		}

		System.out.println("""
				=========================
				Thank you!
				=========================
				""");
	}

	private void write(String message) {
		
		try(var channel = FileChannel.open(Path.of(destination), 
				StandardOpenOption.CREATE,
				StandardOpenOption.APPEND,
				StandardOpenOption.WRITE)) {
			
			var charset = Charset.defaultCharset();
			var buffer = charset.encode(message.concat("\r\n"));
			channel.write(buffer);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
