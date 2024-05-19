package com.jdc.pos.features;

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
}
