package com.jdc.collections;

import java.util.Collection;

public interface StudentRepository {

	int add(Student student);
	
	Collection<Student> getAll();
	
	Student findById(int id);
	
	boolean delete(int id);
	
	boolean update(Student student);
}
