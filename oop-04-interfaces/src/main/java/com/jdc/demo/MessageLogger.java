package com.jdc.demo;

public interface MessageLogger 
	extends Messenger, Logger{

	default void sendMail(String message) {
		Logger.super.sendMail(message);
	}

	static void demo() {
		
	}
}
