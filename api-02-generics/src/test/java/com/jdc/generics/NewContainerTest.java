package com.jdc.generics;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class NewContainerTest {

	@Test
	void test() {
		
		var container = new NewContainer<String>();
		
		container.setValue("Hello Java");
		var value = container.getValue();
		
		System.out.println(value.length());
		
		var dateContainer = new NewContainer<Date>();
		dateContainer.setValue(new Date());
		var date = dateContainer.getValue();
		System.out.println(date);
		
		var intContainer = new NewContainer<Integer>();
		intContainer.setValue(10);
	}
}
