package com.jdc.demo;

public interface Logger {

	void log(String message);
	
	default void sendMail(String message) {
	}
	
}
