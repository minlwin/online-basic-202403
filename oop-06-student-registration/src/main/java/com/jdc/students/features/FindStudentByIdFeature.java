package com.jdc.students.features;

import com.jdc.console.app.AbstractFeature;

public class FindStudentByIdFeature extends AbstractFeature{

	public FindStudentByIdFeature(int id) {
		super(id, "Find Student By Id");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBusiness() {
		System.out.println("Doing Find Student By ID");
	}

}
