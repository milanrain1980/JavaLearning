package com.ibm.mom.object;

import java.util.*;

/**
 * This program demonstrates enumerated types.
 * 
 * @version 1.0 2004-05-24
 * @author Cay Horstmann
 */
public class EnumTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
		String input = in.next().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("size=" + size);
		System.out.println("abbreviation=" + size.getAbbreviation());
		System.out.println("toString=" + size.toString());
		System.out.println("ordinal=" + size.ordinal());
		if (size == Size.EXTRA_LARGE)
			System.out.println("Good job--you paid attention to the _.");
	}
}

enum Size {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

	private Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	private String abbreviation;
}
