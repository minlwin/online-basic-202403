package com.jdc.demo;

public record Ractangle(int base, int height) 
	implements Shape{

	@Override
	public int getArea() {
		return base * height;
	}

}
