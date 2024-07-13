package com.jdc.collections;

public record Product(int id, String name) implements Comparable<Product>{

	@Override
	public int compareTo(Product other) {
		return this.id - other.id;
	}

}
