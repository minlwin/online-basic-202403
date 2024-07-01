package com.jdc.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class StudentRepositoryWithSet implements StudentRepository{

	private Set<Student> set;
	
	private static int ID = 0;
	
	public StudentRepositoryWithSet() {
		set = new LinkedHashSet<>();
	}
	
	@Override
	public int add(Student student) {
		
		validate(student);
		
		set.add(student.withId(++ ID));
		
		return ID;
	}


	@Override
	public Collection<Student> getAll() {
		return Set.copyOf(set);
	}

	@Override
	public Student findById(int id) {
		
		for(var student : set) {
			if(student.id() == id) {
				return student;
			}
		}
		
		return null;
	}

	@Override
	public boolean delete(int id) {
		
		var student = findById(id);
		
		if(null != student) {
			return set.remove(student);
		}
		
		return false;
	}

	@Override
	public boolean update(Student student) {
		
		validate(student);
		
		if(delete(student.id())) {
			return set.add(student);
		}
		
		return false;
	}

	private void validate(Student student) {
		
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
