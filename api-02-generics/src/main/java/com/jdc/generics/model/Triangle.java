package com.jdc.generics.model;

public record Triangle(double base, double height) implements Shape {

	@Override
	public double getArea() {
		return (base * height) / 2;
	}

}
