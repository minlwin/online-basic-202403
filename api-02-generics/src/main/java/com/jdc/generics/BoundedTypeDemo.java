package com.jdc.generics;

import com.jdc.generics.model.Shape;

public class BoundedTypeDemo<T extends Shape> {

	private T shape;
	
	public void setShape(T shape) {
		this.shape = shape;
	}
	
	public T getShape() {
		return shape;
	}
	
	public void showArea() {
		System.out.printf("Area is : %f%n", shape.getArea());
	}
}
