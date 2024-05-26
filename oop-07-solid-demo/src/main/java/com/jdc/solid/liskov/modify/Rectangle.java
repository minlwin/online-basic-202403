package com.jdc.solid.liskov.modify;

public class Rectangle extends Shape{
	
	private int height;

	@Override
	public int getArea() {
		return super.getBase() * height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

}
