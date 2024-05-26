package com.jdc.solid.liskov.modify;

import org.junit.jupiter.api.Test;

public class ModifyTest {
	
	@Test
	void test() {
		Shape rectangle = new Rectangle();
		rectangle.setBase(10);
		if(rectangle instanceof Rectangle) {
			var rect = (Rectangle)rectangle;
			rect.setHeight(5);
		}
	
		showArea(rectangle);
		
		Shape square = new Square();
		square.setBase(10);
		
		showArea(square);
	}

	void showArea(Shape shape) {
		var name = shape.getClass().getSimpleName();
		System.out.printf("Base of %s is %d.%n", name, shape.getBase());
		
		if(shape instanceof Rectangle) {
			var rect = (Rectangle)shape;
			System.out.printf("Height of %s is %d.%n", name, rect.getHeight());
		}
		
		System.out.printf("Area of %s is %d.%n%n", name, shape.getArea());
	}

}
