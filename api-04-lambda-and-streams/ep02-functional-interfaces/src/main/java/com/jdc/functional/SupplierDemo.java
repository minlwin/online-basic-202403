package com.jdc.functional;

import java.util.function.Supplier;

public class SupplierDemo {
	
	public static void main(String[] args) {
		print(() -> "Hello Supplier Functional Interface");
	}

	static void print(Supplier<String> supplier) {
		System.out.println(supplier.get());
	}
}
