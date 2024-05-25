package com.jdc.pos.features;

import com.jdc.console.app.AbstractFeature;
import com.jdc.pos.models.ProductModel;

public class ProductAddFeature extends AbstractFeature {

	private ProductModel model;

	public ProductAddFeature(int id, ProductModel model) {
		super(id, "Add New Product");
		this.model = model;
	}

	@Override
	public void doBusiness() {
		System.out.println("Please enter product information");

		// get product name
		var name = getInputString("Enter Name : ");

		// get product price
		var price = getInputInt("Enter Price : ");

		// add to model
		int id = model.addProduct(name, price);

		System.out.printf("%s has been created at id %d.%n%n", name, id);
	}

}
