package com.jdc.generics;

public class WildCardAndBoundedType {

	public static void upperBound(NewContainer<? extends Number> input) {
		
		Number value = input.getValue();
		System.out.println(value.doubleValue());
	}
	
	public static void lowerBound(NewContainer<? super Integer> output) {
		
		output.setValue(100);
	}
}
