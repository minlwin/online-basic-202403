package com.jdc.students.features;

import com.jdc.console.app.AbstractFeature;

public class AddNewStudentFeature extends AbstractFeature{

	public AddNewStudentFeature(int id) {
		super(id, "Add New Student");
	}

	@Override
	public void doBusiness() {
		System.out.println("Doing Add New Student");
	}

}
