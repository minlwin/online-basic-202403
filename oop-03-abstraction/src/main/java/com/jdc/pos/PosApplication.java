package com.jdc.pos;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.ConsoleApplication;
import com.jdc.pos.features.ProductAddFeature;
import com.jdc.pos.features.ProductSearchFeature;
import com.jdc.pos.features.SaleHistoryFeature;
import com.jdc.pos.features.SalesItemsFeature;
import com.jdc.pos.models.ProductModel;
import com.jdc.pos.models.ProductModelImpl;
import com.jdc.pos.models.SaleModel;
import com.jdc.pos.models.SaleModelImpl;

public class PosApplication {
	
	public static void main(String[] args) {
		
		ProductModel productModel = new ProductModelImpl();
		SaleModel saleModel = new SaleModelImpl();
		
		var features = new AbstractFeature[]{
			new ProductAddFeature(1, productModel),
			new ProductSearchFeature(2, productModel),
			new SalesItemsFeature(3, productModel, saleModel),
			new SaleHistoryFeature(4, saleModel),
			new AbstractFeature(5, "Show Voucher") {
				
				@Override
				public void doBusiness() {
					System.out.println("Show Voucher Featrue");
				}
			}
		};
		
		new ConsoleApplication(features).launch();
		
	}
	
}
