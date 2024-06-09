package com.jdc.account.model;

public sealed interface AccountState permits
	Student.Status, Employee.Status, Teacher.Status{

}
