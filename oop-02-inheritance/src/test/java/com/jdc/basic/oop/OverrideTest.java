package com.jdc.basic.oop;

import org.junit.jupiter.api.Test;

public class OverrideTest {

	@Test
	void test() {
		
		var course = new DrivingCourse(new Car[] {
			new Car(3.0), new SportCar(), new SportSuvCar()	
		});
		
		course.start();
	}
}
