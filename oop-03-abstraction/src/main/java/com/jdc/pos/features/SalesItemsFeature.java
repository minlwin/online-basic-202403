package com.jdc.pos.features;

public class SalesItemsFeature extends AbstractFeature {

	public SalesItemsFeature(int id) {
		super(id, "Sale Items");
	}

	@Override
	public void doBusiness() {
		System.out.println("Sales Item Feature");
	}

}
