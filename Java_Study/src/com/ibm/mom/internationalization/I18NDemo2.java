package com.ibm.mom.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NDemo2 {
	public static void main(String[] args) {
		Locale zhLoc = new Locale("zh", "CN");
		Locale enLoc = new Locale("en", "US");
		Locale frLoc = new Locale("fr", "FR");
		
		ResourceBundle zhRb = ResourceBundle.getBundle("Message", zhLoc);
		ResourceBundle enRb = ResourceBundle.getBundle("Message", enLoc);
		ResourceBundle frRb = ResourceBundle.getBundle("Message", frLoc);
		
		System.out.println("Chinese: " + zhRb.getString("info"));
		System.out.println("English: " + enRb.getString("info"));
		System.out.println("France: " + frRb.getString("info"));
	}
}
