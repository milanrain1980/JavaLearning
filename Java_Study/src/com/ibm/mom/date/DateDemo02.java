package com.ibm.mom.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateDemo02 {

	public static void main(String[] args) {
		Calendar cal = null;
		cal = new GregorianCalendar();
		
		System.out.println("Year: " + cal.get(Calendar.YEAR));
		System.out.println("Month: " + (cal.get(Calendar.MONTH) + 1));
		System.out.println("Date: " + cal.get(Calendar.DAY_OF_MONTH));
	}

}
