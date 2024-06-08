package com.jdc.demo;

public sealed interface Shape permits Ractangle, Square{

	int getArea();
}
