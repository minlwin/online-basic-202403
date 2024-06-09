package com.jdc.account.model;

public class LoginService {
	
	private LoginUser[] users;

	public LoginResult login(LoginUser account) {
		
		for(var user : users) {
			if(user.loginId().equals(account.loginId()) && 
					user.password().equals(account.password())) {
				// return login result
				if(isActive(account)) {
					return getLoginresult(account, "Login Success");
				}
			}
		}
		
		return null;
	}
	
	// Pattern Matching in switch expression with record pattern
	private LoginResult getLoginresult(LoginUser account, String message) {
		return switch(account) {
		case Employee(var name, var loginId, var pass, var role, var status) -> 
			new LoginResult(name, loginId, message);
		case Student(var code, var name, var pass, var status, var start, var end) -> 
			new LoginResult(name, code, message);
		case Teacher(var loginId, var pass, var name, var status) -> 
			new LoginResult(name, loginId, message);
		};
	}

	// Pattern Matching in switch expression with type pattern
	private boolean isActive(LoginUser account) {
		return switch(account) {
		case Employee e -> isActive(e.status());
		case Student s -> isActive(s.status());
		case Teacher t -> isActive(t.status());
		};
	}
	
	private boolean isActive(AccountState state) {
		return switch(state) {
		case 
			com.jdc.account.model.Student.Status.Active,
			com.jdc.account.model.Teacher.Status.Active,
			com.jdc.account.model.Employee.Status.Active,
			com.jdc.account.model.Employee.Status.Leave
			-> true;
		case 
			com.jdc.account.model.Student.Status.Finished,
			com.jdc.account.model.Teacher.Status.Retired,
			com.jdc.account.model.Employee.Status.Retired
			-> false;
		default -> false;
		};
	}
}
