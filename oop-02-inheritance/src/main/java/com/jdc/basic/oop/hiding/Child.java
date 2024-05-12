package com.jdc.basic.oop.hiding;

public class Child extends Super{

	protected int data = 5;

	@Override
	public void showData() {
		System.out.println(super.data);
	}
}
