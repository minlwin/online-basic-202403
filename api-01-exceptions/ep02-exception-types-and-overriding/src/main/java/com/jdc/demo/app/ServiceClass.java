package com.jdc.demo.app;

public class ServiceClass {

	private ModelClass model = new ModelClass();
	
	public String [] search(String param) {
		return model.search(param);
	}
}
