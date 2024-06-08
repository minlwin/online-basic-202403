package com.jdc.demo.inf;

public sealed interface Card 
	permits CardForData, CardForGame, CardForObj {

}
