package com.jdc.console.app;

import java.util.Scanner;

public abstract class AbstractFeature {

	private int id;
	private String name;
	
	private static Scanner scanner = new Scanner(System.in);

	public AbstractFeature(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public abstract void doBusiness();
	
	public String getTitle() {
		return "%d. %s".formatted(id, name);
	}
	
	public int getId() {
		return id;
	}
	
	protected String getInputString(String message) {
		System.out.print(message);
		return scanner.nextLine();
	}
	
	protected int getInputInt(String message) {
		var input = getInputString(message);
		return Integer.parseInt(input);
	}
	
	protected int getInputInt(String message, int retryCount, String errorMessage) {
		
		var count = 0; 
		
		while(count < retryCount) {
			try {
				var input = getInputString(message);
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);
				System.out.println();
			}
			
			count ++;
		}
		
		throw new RuntimeException("You have failed %d count.".formatted(count));
	}	
}
