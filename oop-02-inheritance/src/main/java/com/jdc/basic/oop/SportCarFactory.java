package com.jdc.basic.oop;

public class SportCarFactory extends CarFactory{

	public SportCar create() {
		return new SportCar();
	}
}
