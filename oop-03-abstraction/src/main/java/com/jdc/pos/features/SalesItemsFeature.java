package com.jdc.pos.features;

import java.util.Arrays;

import com.jdc.pos.models.Product;
import com.jdc.pos.models.ProductModel;
import com.jdc.pos.models.Sale;
import com.jdc.pos.models.SaleItem;
import com.jdc.pos.models.SaleModel;

public class SalesItemsFeature extends AbstractFeature {

	private ProductModel productModel;
	private SaleModel saleModel;
	
	public SalesItemsFeature(int id, ProductModel productModel, SaleModel saleModel) {
		super(id, "Sale Items");
		this.productModel = productModel;
		this.saleModel = saleModel;
	}

	@Override
	public void doBusiness() {
		System.out.println("Create New Sale.");
		
		SaleItem [] items = {};
		
		do {
			// get product
			var product = getProduct();
			
			// get quantity
			var quantity = getInputInt("Enter Quantity : ");
			
			// add to cart
			items = Arrays.copyOf(items, items.length + 1);
			items[items.length - 1] = new SaleItem(product, quantity);
			
			// add more
		} while(addMore());
		
		// check out
		Sale sale = saleModel.checkOut(items);
		System.out.printf("Total amount is %d.%n%n", sale.totalAmount());
	}

	private Product getProduct() {	
		while(true) {
			var id = getInputInt("Enter Product id : ");
			
			var product = productModel.findById(id);
			
			if(null != product) {
				return product;
			}
			
			System.out.printf("There is no product with id :d.%n%n", id);
		}
	}

	private boolean addMore() {
		var result = "Y".equalsIgnoreCase(getInputString("Do you want to add more? (Y/Others) : "));
		System.out.println();
		return result;
	}

}
