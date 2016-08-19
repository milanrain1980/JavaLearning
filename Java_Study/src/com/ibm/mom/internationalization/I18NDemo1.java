package com.ibm.mom.internationalization;

import java.util.ResourceBundle;

public class I18NDemo1 {

	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("Message");
		
		System.out.println("Content is: " + rb.getString("info"));
	}

}
