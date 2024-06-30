package com.jdc.generics;

public class NewContainer<T> {

	private T value;
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
}
