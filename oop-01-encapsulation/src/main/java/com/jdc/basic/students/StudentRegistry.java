package com.jdc.basic.students;

import java.util.Arrays;

public class StudentRegistry {
	
	private Student[] students = {};
	private int id;

	public Student add(Student student) {
		students = Arrays.copyOf(students, students.length + 1);
		students[students.length - 1] = student.withId(++ id);
		return students[students.length - 1];
	}
	
	public Student[] getAll() {
		return Arrays.copyOf(students, students.length);
	}
	
	public Student findById(int id) {
		if(id >= 0 && id < students.length) {
			return students[id - 1];
		}
		
		return null;
	}
}
