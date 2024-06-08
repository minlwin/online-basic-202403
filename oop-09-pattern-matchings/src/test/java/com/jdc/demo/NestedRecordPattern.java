package com.jdc.demo;

import org.junit.jupiter.api.Test;

public class NestedRecordPattern {

	@Test
	void test() {
		
		var pair = new Pair(new Data(10), new Data(5));
		
		if(pair instanceof Pair(Data(var a), Data(var b))) {
			System.out.println("Key is " + a);
			System.out.println("Value is " + b);
		}
	}
}
