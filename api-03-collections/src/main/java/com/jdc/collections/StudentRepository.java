package com.jdc.collections;

import java.util.Collection;
import java.util.LinkedHashSet;

public interface StudentRepository {

	int add(Student student);
	
	Collection<Student> getAll();
	
	Student findById(int id);
	
	boolean delete(int id);
	
	boolean update(Student student);
	
	public default void validate(Student student) {
		
		var messages = new LinkedHashSet<String>();

		if(null == student.name() || student.name().isBlank()) {
			messages.add("Please enter student name.");
		}
		
		if(null == student.dob()) {
			messages.add("Please enter date of birth.");
		}
		
		if(null == student.gender()) {
			messages.add("Please enter gender of student.");
		}
		
		if(!messages.isEmpty()) {
			throw new BusinessException(messages);
		}
		
	}	
}
