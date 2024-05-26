package com.jdc.solid.liskov.failure;

public class Square extends Shape{

	@Override
	public void setBase(int base) {
		super.setBase(base);
		super.setHeight(base);
	}
	
	@Override
	public void setHeight(int height) {
		throw new IllegalArgumentException();
	}
}
