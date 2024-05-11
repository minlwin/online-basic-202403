package com.jdc.basic.students;

public record Student(
		int id,
		String name,
		String phone,
		String email) {
	
	public Student(String name, String phone, String email) {
		this(0, name, phone, email);
	}

	public Student withId(int i) {
		return new Student(i, name, phone, email);
	}
}
