package com.jdc.demo.app.exceptions;

public class ApplicationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public enum Type {
		Info, Warning, Error
	}
	
	private Type type;

	public ApplicationException(Type type) {
		super();
		this.type = type;
	}

	public ApplicationException(Type type, String message, Throwable cause) {
		super(message, cause);
		this.type = type;
	}

	public ApplicationException(Type type, String message) {
		super(message);
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}

}
