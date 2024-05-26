package com.jdc.solid.liskov.modify;

public abstract class Shape {

	private int base;
	
	public abstract int getArea();
	
	public int getBase() {
		return base;
	}
	
	public void setBase(int base) {
		this.base = base;
	}
}
