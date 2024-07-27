package com.jdc.demo;

public record Product(
		int id, String name, int price) {

	public static Product from(String [] array) {
		return new Product(
				Integer.parseInt(array[0]), 
				array[1], 
				Integer.parseInt(array[2]));
	}
}
