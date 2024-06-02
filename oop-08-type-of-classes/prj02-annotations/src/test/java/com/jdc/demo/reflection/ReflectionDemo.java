package com.jdc.demo.reflection;

import org.junit.jupiter.api.Test;

import com.jdc.demo.usage.domain.Student;

public class ReflectionDemo {

	@Test
	void test() {
		
		var student = new Student();
		
		var fields = student.getClass().getDeclaredFields();
		
		System.out.println("====== Instance Variables =======");
		for(var field : fields) {
			System.out.println(field.getName());
			
			if(field.getName().equals("name")) {
				field.setAccessible(true);
				try {
					field.set(student, "Aung Aung");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("====== Mehtods =========");
		var methods = student.getClass().getMethods();
		for(var method : methods) {
			System.out.println(method.getName());
		}
		
		System.out.printf("Name is %s.%n", student.getName());
	}
}
