package com.ibm.mom.date;

import java.text.DateFormat;
import java.util.Date;

public class DateDemo03 {

	public static void main(String[] args) {
		DateFormat df1 = null;
		DateFormat df2 = null;
		df1 = DateFormat.getDateInstance();
		df2= DateFormat.getDateTimeInstance();
		
		System.out.println("Date: " + df1.format(new Date()));
		System.out.println("DateTime: " + df2.format(new Date()));
	}

}
