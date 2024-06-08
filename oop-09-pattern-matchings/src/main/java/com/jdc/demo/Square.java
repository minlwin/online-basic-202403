package com.jdc.demo;

public record Square(int base) implements Shape {

	@Override
	public int getArea() {
		return base * base;
	}

}
