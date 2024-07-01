package com.jdc.collections;

import java.time.LocalDate;

public record Student(
		int id,
		String name,
		LocalDate dob,
		Gender gender,
		String phone,
		String email
		) {
	
	public Student withId(int id) {
		return new Student(id, name, dob, gender, phone, email);
	}

	public enum Gender {
		Male, Female
	}
}
