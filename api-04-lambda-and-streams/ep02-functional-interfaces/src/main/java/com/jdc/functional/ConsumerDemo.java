package com.jdc.functional;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		List<String> strList = List.of("Java Basic", "Spring", "Angular", "Docker");
				
		Consumer<String> printToUpper = str -> System.out.println(str.toUpperCase());
		Consumer<String> printToLower = str -> System.out.println(str.toLowerCase());
		Consumer<String> printUpperAndLower = printToUpper.andThen(printToLower);
		
		strList.forEach(printUpperAndLower);
	}
}
