package com.jdc.pos.features;

public class SaleHistoryFeature extends AbstractFeature{

	public SaleHistoryFeature(int id) {
		super(id, "Sale History");
	}

	@Override
	public void doBusiness() {
		System.out.println("Sale History Feature");
	}

}
