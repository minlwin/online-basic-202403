package com.jdc.basic.oop;

public class SportSuvCar extends SportCar{
	
	public SportSuvCar() {
		System.out.println("Sport Suv Car Constructor");
	}

	public void startFourWheel() {
		System.out.println("Driving with four wheel mode.");
	}
	
	@Override
	public void drive() {
		System.out.println("Driving and drifting on rough road.");
	}
}
