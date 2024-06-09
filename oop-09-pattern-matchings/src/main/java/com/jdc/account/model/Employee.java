package com.jdc.account.model;

public record Employee(
		String name,
		String loginId,
		String password,
		Role role,
		Status status
		) implements LoginUser {
	
	public enum Status implements AccountState{
		Active, Leave, Retired
	}

	public enum Role {
		Manager, Employee
	}
}
