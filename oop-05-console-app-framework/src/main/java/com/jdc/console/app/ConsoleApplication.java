package com.jdc.console.app;

import java.util.Scanner;

public class ConsoleApplication {

	private AbstractFeature[] features;
	private Scanner scanner;
	

	public ConsoleApplication(AbstractFeature[] features) {
		super();
		this.features = features;
		scanner = new Scanner(System.in);
	}

	public void launch() {
		showMessage("Pos Application");
		
		do {
			
			try {
				var feature = getUserSelectFeature();
				feature.doBusiness();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Please enter valid menu id.");
				System.out.println();
			}

		} while(doAgain());
	}

	private AbstractFeature getUserSelectFeature() {
		
		System.out.println("Please select menu id.");
		for(var feature : features) {
			System.out.println(feature.getTitle());
		}
		System.out.println();
		
		System.out.print("Enter Menu ID : ");
		var result = scanner.nextLine();
		var resultId = Integer.parseInt(result);
		
		return features[resultId - 1];
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
