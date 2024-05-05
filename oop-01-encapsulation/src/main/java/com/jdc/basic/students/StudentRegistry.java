package com.jdc.basic.students;

import java.util.Arrays;

public class StudentRegistry {
	
	private Student[] students = {};
	private int id;

	public Student add(Student student) {
		student.setId(++ id);
		students = Arrays.copyOf(students, students.length + 1);
		students[students.length - 1] = student;
		return student;
	}
	
	public Student[] getAll() {
		return students;
	}
}
