package com.jdc.basic.oop;

public class SportCar extends Car {
	
	public SportCar() {
		super(8.0);
		System.out.println("Sport Car with default power");
	}
	
	public SportCar(double power) {
		super(power);
		System.out.println("Sport Car with Customer Power");
	}

	public void turboOn() {
		System.out.println("Turbo Mode On");
	}
}
