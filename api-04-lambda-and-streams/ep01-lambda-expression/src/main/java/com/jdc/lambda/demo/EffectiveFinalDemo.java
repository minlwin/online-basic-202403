package com.jdc.lambda.demo;

public class EffectiveFinalDemo {

	public static void main(String[] args) {
		
		String message = "Hello Lambda";
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(message);
			}
		};
		
		runnable.run();
	
	}
}
