package com.jdc.functional;

import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		Predicate<Integer> evenNumber = a -> a % 2 == 0;
		Predicate<Integer> gtFive = a -> a > 5;
		
		list.forEach(a -> {
			if(evenNumber.and(gtFive.negate()).test(a)) {
				System.out.println(a);
			}
		});
	}
}
