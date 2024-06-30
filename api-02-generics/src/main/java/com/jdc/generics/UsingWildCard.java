package com.jdc.generics;

public class UsingWildCard {

	private SuperType<?> value;

	public UsingWildCard(SuperType<?> value) {
		super();
		this.value = value;
	}
	
	public SuperType<?> getValue() {
		return value;
	}
	
	public void setValue(SuperType<?> value) {
		this.value = value;
	}
}
