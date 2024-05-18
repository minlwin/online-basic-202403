package com.jdc.pos.features;

public class ProductSearchFeature extends AbstractFeature{

	public ProductSearchFeature(int id) {
		super(id, "Search Product");
	}

	@Override
	public void doBusiness() {
		System.out.println("Product Search Feature");
	}

}
