package com.jdc.demo.before;

public enum EnumDaysOfWeek {

	MON("Monday"), 
	TUE("Tuesday"), 
	WED("Wednesday"), 
	THU("Thursday"), 
	FRI("Friday"), 
	SAT("Saturday"), 
	SUN("Sunday");

	private String displayName;
	
	private EnumDaysOfWeek(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public int getValue() {
		return ordinal() + 1;
	}
}
