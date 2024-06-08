package com.jdc.demo;

public record StudentData(
		String code, 
		String name, 
		String phone, 
		String email) {
	
	// Compact Canonical Constructor
	public StudentData {
		if(null == code || code.isBlank()) {
			throw new IllegalArgumentException();
		}
	}
	
	public StudentData(String code, String name) {
		this(code, name, null, null);
	}

	public StudentData(String code, String name, String phone) {
		this(code, name, phone, null);
	}
}
