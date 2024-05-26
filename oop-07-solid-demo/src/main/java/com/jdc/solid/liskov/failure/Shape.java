package com.jdc.solid.liskov.failure;

public abstract class Shape {

	private int base;
	private int height;
	
	public int getArea() {
		return base * height;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
