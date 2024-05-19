package com.jdc.pos.models;

public interface ProductModel {
	int addProduct(String name, int price);
	Product findById(int id);
}
