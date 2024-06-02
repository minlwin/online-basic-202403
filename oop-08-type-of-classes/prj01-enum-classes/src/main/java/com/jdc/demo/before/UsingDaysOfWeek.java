package com.jdc.demo.before;

public class UsingDaysOfWeek {

	public static String getDayType(int day) {
		return switch(day) {
		case DaysOfWeek.SAT, DaysOfWeek.SUN -> "Weekend";
		case DaysOfWeek.MON, DaysOfWeek.TUE, DaysOfWeek.WED,
			DaysOfWeek.THU, DaysOfWeek.FRI -> "Weekday";
		default -> "Impossible";
		};
	}
	
	public static String getType(EnumDaysOfWeek day) {
		return switch(day) {
		case MON, TUE, WED, THU, FRI -> "Weekday";
		case SAT, SUN -> "Weekend";
		};
	}
	
	public static void main(String[] args) {
		var firstDay = DaysOfWeek.MON;
		System.out.println(firstDay);
		
		firstDay = -10;
		
		System.out.println(firstDay);
		
		var otherDay = EnumDaysOfWeek.MON;
		System.out.println(otherDay);
		
		var values = EnumDaysOfWeek.values();
		
		for(var day : values) {
			System.out.printf("%d - %s%n", day.ordinal(), day.name());
			System.out.printf("%d - %s%n", day.getValue(), day.getDisplayName());
		}
		
		var day = EnumDaysOfWeek.valueOf("MON");
		System.out.println(day);
	}
}
