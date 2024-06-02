package com.jdc.demo.usage.domain;

import java.time.LocalDate;

import com.jdc.demo.usage.NotBlank;
import com.jdc.demo.usage.NotNull;

import lombok.Data;

@Data
public class Student {

	@NotBlank("Please enter student name.")
	private String name;
	
	@NotBlank("Please enter phone number.")
	private String phone;
	
	@NotNull("Please enter date of birth.")
	private LocalDate dob;
}
