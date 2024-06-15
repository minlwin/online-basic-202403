package com.jdc.demo;

public class Service2 {
	
	private Service3 service = new Service3();

	public void execute(int a, int b) {
		try {
			System.out.println("Execute Service 2");
			service.execute(a, b);
			System.out.println("Finish Service 2");
		} catch (RuntimeException e) {
			System.out.println("Handle IllegalArgumentException");
		}
	}

}
