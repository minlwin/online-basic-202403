package com.jdc.functional;

import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {
		var result = findCharCount("Hello java and we love java", 'a');
		System.out.println(result);
	}
	
	static int findCharCount(String str, char c) {
		Function<String, char[]> strToCharArray = a -> a.toCharArray();
		
		Function<char[], Integer> countChar =  array -> {
			int count = 0; 
			
			for(var item : array) {
				if(item == c) {
					count ++;
				}
			}
			
			return count;
		};
		
		return strToCharArray.andThen(countChar).apply(str);
	}
}
