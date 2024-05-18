package com.jdc.pos;

import java.util.Scanner;

import com.jdc.pos.features.AbstractFeature;
import com.jdc.pos.features.ProductAddFeature;
import com.jdc.pos.features.ProductSearchFeature;
import com.jdc.pos.features.SaleHistoryFeature;
import com.jdc.pos.features.SalesItemsFeature;

public class PosApplication {
	
	private AbstractFeature[] features;
	private Scanner scanner;
	
	public PosApplication(AbstractFeature[] features) {
		super();
		this.features = features;
		this.scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		var features = new AbstractFeature[]{
			new ProductAddFeature(1),
			new ProductSearchFeature(2),
			new SalesItemsFeature(3),
			new SaleHistoryFeature(4),
			new AbstractFeature(5, "Show Voucher") {
				
				@Override
				public void doBusiness() {
					System.out.println("Show Voucher Featrue");
				}
			}
		};
		
		new PosApplication(features).launch();
	}
	
	public void launch() {
		showMessage("Pos Application");
		
		do {
			var feature = getUserSelectFeature();
			
			if(null == feature) {
				break;
			} 
			
			feature.doBusiness();
			
		} while(doAgain());
	}

	private AbstractFeature getUserSelectFeature() {
		
		System.out.println("Please select menu id.");
		for(var feature : features) {
			System.out.println(feature.getTitle());
		}
		
		var result = scanner.nextLine();
		var resultId = Integer.parseInt(result);
		
		if(resultId <= features.length) {
			return features[resultId - 1];
		}
		
		return null;
	}

	private boolean doAgain() {
		System.out.print("Do you want to continue? (y/others) : ");
		var result = scanner.nextLine();
		return "Y".equalsIgnoreCase(result);
	}

	private void showMessage(String message) {
		System.out.println("======================");
		System.out.println(message);
		System.out.println("======================");
		System.out.println();
	}
}
