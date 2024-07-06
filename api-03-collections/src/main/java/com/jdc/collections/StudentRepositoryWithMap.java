package com.jdc.collections;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryWithMap implements StudentRepository{

	private Map<Integer, Student> map;
	private static int ID;
	
	public StudentRepositoryWithMap() {
		map = new LinkedHashMap<>();
	}
	
	@Override
	public int add(Student student) {
		validate(student);
		map.put(++ ID, student.withId(ID));
		return ID;
	}

	@Override
	public Collection<Student> getAll() {
		return List.copyOf(map.values());
	}

	@Override
	public Student findById(int id) {
		return map.get(id);
	}

	@Override
	public boolean delete(int id) {
		return map.remove(id) != null;
	}

	@Override
	public boolean update(Student student) {
		
		validate(student);
		
		if(map.containsKey(student.id())) {
			return map.put(student.id(), student) != null;
		}
		
		return false;
	}

}
