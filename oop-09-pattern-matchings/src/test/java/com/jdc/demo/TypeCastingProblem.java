package com.jdc.demo;

import org.junit.jupiter.api.Test;

public class TypeCastingProblem {

	@Test
	void test() {
		
		Square square = new Square(10);
		
		Shape s2 = square;
		
		// Type Pattern
		if(s2 instanceof Ractangle r1) {
			System.out.printf("Base : %d%n", r1.base());
			System.out.printf("Height : %d%n", r1.height());
			System.out.printf("Area : %d%n", r1.getArea());
		}
		
		// Record Pattern
		if(s2 instanceof Ractangle(var base, var height)) {
			System.out.printf("Base : %d%n", base);
			System.out.printf("Height : %d%n", height);
			System.out.printf("Area : %d%n", base * height);
		}		
	}
}
