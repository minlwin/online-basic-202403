package com.jdc.pos.features;

public class ProductAddFeature extends AbstractFeature{

	public ProductAddFeature(int id) {
		super(id, "Add New Product");
	}

	@Override
	public void doBusiness() {
		System.out.println("Product Add Feature");
	}

}
