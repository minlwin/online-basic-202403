package com.jdc.demo.usage;

public enum PlayingCard implements Card{
	SpadeA, DimondA;
	
	@Override
	public int value() {
		return ordinal() + 1;
	}
}
