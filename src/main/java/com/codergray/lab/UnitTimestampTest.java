package com.codergray.lab;

import java.util.Calendar;
import java.util.TimeZone;

public class UnitTimestampTest {

	public static void main(String[] args) {
		System.out.println(getCurrentUnixTimeInSeconds(TimeZone.getTimeZone("Asia/Shanghai")));
		System.out.println(System.currentTimeMillis()/1000);
	}

	public static String getCurrentUnixTimeInSeconds(TimeZone zone) {
		Calendar calendar = Calendar.getInstance(zone);
		return Long.toString(calendar.getTime().getTime() / 1000);
	}
}