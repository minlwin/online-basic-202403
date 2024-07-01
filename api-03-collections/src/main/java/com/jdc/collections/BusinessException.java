package com.jdc.collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Set<String> messages = new LinkedHashSet<String>();

	public BusinessException(Set<String> messages) {
		super();
		this.messages = messages;
	}

	public Set<String> getMessages() {
		return messages;
	}

}
