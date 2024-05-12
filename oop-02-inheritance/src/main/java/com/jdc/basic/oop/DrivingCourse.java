package com.jdc.basic.oop;

public class DrivingCourse {

	private Car [] cars;

	public DrivingCourse(Car[] cars) {
		super();
		this.cars = cars;
	}
	
	public void start() {
		for(Car car : cars) {
			car.drive();
		}
	}
}
