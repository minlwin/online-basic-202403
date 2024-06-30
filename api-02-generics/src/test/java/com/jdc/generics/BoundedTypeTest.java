package com.jdc.generics;

import org.junit.jupiter.api.Test;

import com.jdc.generics.model.Shape;
import com.jdc.generics.model.Square;
import com.jdc.generics.model.Triangle;

public class BoundedTypeTest {

	@Test
	void test() {
		
		Shape shape1 = new Triangle(10, 20);
		
		BoundedTypeDemo<Shape> c1 = new BoundedTypeDemo<>();
		c1.setShape(shape1);
		c1.showArea();
		
		
		var c2 = new BoundedTypeDemo<>();
		c2.setShape(shape1);
		c2.showArea();
		
		var c3 = new BoundedTypeDemo<Square>();
		c3.setShape(new Square(10));
		c2.showArea();
	}
}
