package com.jdc.account.model;

public sealed interface LoginUser
	permits Employee, Student, Teacher{

	String loginId();
	String password();
}
