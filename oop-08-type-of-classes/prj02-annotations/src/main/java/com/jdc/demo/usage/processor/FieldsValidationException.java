package com.jdc.demo.usage.processor;

import java.util.List;

public class FieldsValidationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private List<String> messages;

	public FieldsValidationException(List<String> messages) {
		super();
		this.messages = messages;
	}
	
	public List<String> getMessages() {
		return messages;
	}

}
