package com.ibm.mom.numberformat;

import java.text.NumberFormat;

public class NumberFormatDemo01 {

	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getInstance();
		System.out.println(nf.format(1000000));
		System.out.println(nf.format(1000.345));
	}

}
