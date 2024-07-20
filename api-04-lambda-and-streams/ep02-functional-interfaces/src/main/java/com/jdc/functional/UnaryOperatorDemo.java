package com.jdc.functional;

import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {

	public static void main(String[] args) {
		
		UnaryOperator<Integer> plusOne = a -> a + 1;
		UnaryOperator<Integer> multiplyWithTwo = a -> a * 2;
		
		System.out.println(plusOne.andThen(multiplyWithTwo).apply(10));
	}
}
