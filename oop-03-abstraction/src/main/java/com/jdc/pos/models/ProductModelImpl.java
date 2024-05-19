package com.jdc.pos.models;

import java.util.Arrays;

public class ProductModelImpl implements ProductModel{

	private Product [] products = {};
	
	@Override
	public int addProduct(String name, int price) {
		var id = products.length + 1;
		products = Arrays.copyOf(products, products.length + 1);
		products[id - 1] = new Product(id, name, price);
		return id;
	}

	@Override
	public Product findById(int id) {
		if(id > 0 && id <= products.length) {
			return products[id - 1];
		}
		return null;
	}

}
