package com.jdc.lambda.demo;

import java.util.List;
import java.util.function.Consumer;

public class BeforeAndAfter {

	public static void before(List<Integer> list) {
		
		list.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		});
	}
	
	public static void after(List<Integer> list) {
		list.forEach(t -> System.out.println(t));
	}	
}
