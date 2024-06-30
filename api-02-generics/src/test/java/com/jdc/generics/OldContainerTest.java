package com.jdc.generics;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class OldContainerTest {

	@Test
	void test() {
		
		var container = new OldContainer();
		
		container.setValue("Hello Java");

		var value = container.getValue();
		var string = (String)value;
		
		System.out.println(string.length());
		
		container.setValue(new Date());

		value = container.getValue();
		string = (String)value;
		System.out.println(string.length());
	}
}
