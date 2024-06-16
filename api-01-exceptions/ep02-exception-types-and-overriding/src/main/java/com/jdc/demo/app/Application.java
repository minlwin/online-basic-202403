package com.jdc.demo.app;

public class Application {

	public static void main(String[] args) {
		
		try {
			var controller = new ControllerClass();
			
			while(true) {
				controller.search();
				System.out.println();
			}
			
		} catch (Exception e) {
			System.out.println("System will shut down because of fatal Error");
			e.printStackTrace();
		}
	}
}
