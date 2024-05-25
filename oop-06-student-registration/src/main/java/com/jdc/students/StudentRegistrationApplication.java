package com.jdc.students;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.ConsoleApplication;
import com.jdc.students.features.AddNewStudentFeature;
import com.jdc.students.features.FindStudentByIdFeature;
import com.jdc.students.features.ShowAllStudentFeature;

public class StudentRegistrationApplication {

	public static void main(String[] args) {
		
		var features = new AbstractFeature [] {
			new AddNewStudentFeature(1),
			new FindStudentByIdFeature(2),
			new ShowAllStudentFeature(3)
		};
		
		new ConsoleApplication(features).launch();
	}
}
