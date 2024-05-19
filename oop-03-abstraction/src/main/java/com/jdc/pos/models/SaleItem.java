package com.jdc.pos.models;

public record SaleItem(
		Product product,
		int quantity) {

	public int total() {
		return product.price() * quantity;
	}
}
