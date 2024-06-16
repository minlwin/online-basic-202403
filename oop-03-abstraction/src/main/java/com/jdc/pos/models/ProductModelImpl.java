package com.jdc.pos.models;

import java.util.Arrays;

import com.jdc.pos.features.exceptions.InputValueInvalidException;

public class ProductModelImpl implements ProductModel{

	private Product [] products = {};
	
	@Override
	public int addProduct(String name, int price) {
		
		if(null == name || name.isBlank()) {
			throw new InputValueInvalidException("Please enter product name.");
		}
		
		if(price < 100) {
			throw new InputValueInvalidException("Price must be enter at least 100.");
		}
		
		var id = products.length + 1;
		products = Arrays.copyOf(products, products.length + 1);
		products[id - 1] = new Product(id, name, price);
		
		return id;
	}

	@Override
	public Product findById(int id) {
		
		try {
			return products[id - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new InputValueInvalidException("Please enter valid product id.");
		}
	}

}
