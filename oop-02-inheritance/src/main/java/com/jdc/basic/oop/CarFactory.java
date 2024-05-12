package com.jdc.basic.oop;

public class CarFactory {

	public Car create() {
		return new SportSuvCar();
	}
}
