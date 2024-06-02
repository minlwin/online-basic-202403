package com.jdc.demo.bridge;

public class AccessDecisionManager {

	public boolean canAccess(AccountStatus status) {
		return switch(status) {
		case EmployeeStatus.Assigned, StudentStatus.Approved -> true;
		case StudentStatus.Applied, EmployeeStatus.Resigned -> false;
		default -> false;
		};
	}
}
