package com.jdc.account.model;

public record Teacher(
		String loginId,
		String password,
		String name, 
		Status status
		) implements LoginUser {

	public enum Status implements AccountState {
		Active, Retired
	}
}
