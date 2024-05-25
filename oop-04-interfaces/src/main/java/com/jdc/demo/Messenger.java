package com.jdc.demo;

public interface Messenger {
	
	void send(String message);

	static Messenger getInstance() {
		return null;
	}
	
	default void sendMail(String message) {
		logMessage(message);
	}
	
	default void sendSms(String message) {
		logMessage(message);
	}
	
	default void sendNoti(String message) {
		logMessage(message);
	}
	
	private void logMessage(String message) {
		System.out.println(message);
	}
	
}
