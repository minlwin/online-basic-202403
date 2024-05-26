package com.jdc.solid.liskov.modify;

public class Square extends Shape{

	@Override
	public int getArea() {
		return getBase() * getBase();
	}

}
