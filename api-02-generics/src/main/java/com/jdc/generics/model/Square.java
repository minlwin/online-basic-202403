package com.jdc.generics.model;

public record Square(double base) implements Shape {

	@Override
	public double getArea() {
		return base * base;
	}

}
