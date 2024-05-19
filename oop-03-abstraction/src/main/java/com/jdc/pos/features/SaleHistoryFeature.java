package com.jdc.pos.features;

import com.jdc.pos.models.Sale;
import com.jdc.pos.models.SaleModel;

public class SaleHistoryFeature extends AbstractFeature{

	private SaleModel model;
	
	public SaleHistoryFeature(int id, SaleModel model) {
		super(id, "Sale History");
		this.model = model;
	}

	@Override
	public void doBusiness() {
		System.out.println("Sale History");
		
		Sale [] sales = model.getHistory();
		
		for(var sale : sales) {
			System.out.println(sale);
		}
	}

}
