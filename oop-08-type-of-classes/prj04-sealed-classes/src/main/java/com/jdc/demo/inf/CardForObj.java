package com.jdc.demo.inf;

public sealed class CardForObj 
	implements Card permits CardForObjOne, CardForObjTwo {

}
