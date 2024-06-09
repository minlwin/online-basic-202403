package com.jdc.account.model;

import java.time.LocalDate;

public record Student(
		String code, 
		String name,
		String password,
		Status status,
		LocalDate entryDate,
		LocalDate finishedDate) implements LoginUser {
	
	@Override
	public String loginId() {
		return code;
	}

	public enum Status implements AccountState {
		Active, Finished
	}
}
