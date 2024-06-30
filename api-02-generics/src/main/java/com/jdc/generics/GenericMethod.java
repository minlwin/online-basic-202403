package com.jdc.generics;

public class GenericMethod {
	
	public static void main(String[] args) {
		var data = new SuperType<String>();
		System.out.println(data);
	}

	public static<T> void show(T data) {
		
	}
}
