package com.jdc.demo;

public record Product(
		int id, String category, String name, int price) implements Comparable<Product>{

	public static Product from(String [] array) {
		return new Product(
				Integer.parseInt(array[0]), 
				array[1], 
				array[2],
				Integer.parseInt(array[3]));
	}

	@Override
	public int compareTo(Product o) {
		return price - o.price;
	}
}
