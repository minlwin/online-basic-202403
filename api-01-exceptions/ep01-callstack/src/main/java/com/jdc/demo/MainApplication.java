package com.jdc.demo;

public class MainApplication {

	public static void main(String[] args) {
		
		try {
			System.out.println("Start Main Method");
			var service = new Service1();
			service.execute(10, 0);
			System.out.println("End Main Method");
		} catch (Exception e) {
			System.out.println("Handle Exception");
		}
	}
}
