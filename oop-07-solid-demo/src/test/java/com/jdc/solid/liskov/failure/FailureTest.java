package com.jdc.solid.liskov.failure;

import org.junit.jupiter.api.Test;

public class FailureTest {

	@Test
	void test() {
		Shape rectangle = new Rectangle();
		rectangle.setBase(10);
		rectangle.setHeight(5);
		
		showArea(rectangle);
		
		Shape square = new Square();
		square.setBase(10);
		square.setHeight(5);
		
		showArea(square);
	}
	
	void showArea(Shape shape) {
		var name = shape.getClass().getSimpleName();
		System.out.printf("Base of %s is %d.%n", name, shape.getBase());
		System.out.printf("Height of %s is %d.%n", name, shape.getHeight());
		System.out.printf("Area of %s is %d.%n%n", name, shape.getArea());
	}
}
