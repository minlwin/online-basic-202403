package com.jdc.basic.oop;

public class Car {

	protected double power;
	
	public Car(double power) {
		super();
		this.power = power;
		System.out.println("Constructing Car");
	}

	public void park() {
		System.out.println("Car is parking!");
	}
	
	public void drive() {
		System.out.println("Car is driving");
	}
}
