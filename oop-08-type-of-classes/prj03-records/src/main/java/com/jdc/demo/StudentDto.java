package com.jdc.demo;

import java.util.Objects;

public final class StudentDto {

	private final String code;
	private final String name;
	private final String phone;
	private final String email;

	public StudentDto(String code, String name, String phone, String email) {
		super();
		this.code = code;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, email, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDto other = (StudentDto) obj;
		return Objects.equals(code, other.code) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "StudentDto [code=" + code + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

}
