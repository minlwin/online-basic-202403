package com.jdc.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentRepositoryWithList implements StudentRepository {

	private List<Student> list;
	private static int ID = 0;
	
	public StudentRepositoryWithList() {
		list = new ArrayList<>();
	}
	
	@Override
	public int add(Student student) {
		
		validate(student);
		
		list.add(student.withId(++ ID));
		
		return ID;
	}

	@Override
	public Collection<Student> getAll() {
		return List.copyOf(list);
	}

	@Override
	public Student findById(int id) {
		
		for(var student : list) {
			if(student.id() == id) {
				return student;
			}
		}
		
		return null;
	}

	@Override
	public boolean delete(int id) {
		var student = findById(id);
		return list.remove(student);
	}

	@Override
	public boolean update(Student student) {
		
		validate(student);
		
		var oldStudent = findById(student.id());
		
		var index = list.indexOf(oldStudent);
		
		if(index >=0 && index <= list.size() - 1) {
			list.set(index, student);
			return true;
		}
		
		return false;
	}

}
