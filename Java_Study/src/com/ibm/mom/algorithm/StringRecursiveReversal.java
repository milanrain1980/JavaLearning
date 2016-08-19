package com.ibm.mom.algorithm;

/**
 * Write a program to reverse a string using recursive methods. You should not use any string reverse methods to do this. 
 * - See more at: http://www.java2novice.com/java-interview-programs/string-reverse-recursive/#sthash.rRW1UjGi.dpuf
 */
public class StringRecursiveReversal {
	String reverse = "";

	public String reverseString(String str) {
		if (str.length() == 1) {
			return str;
		} else {
			reverse += str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
			return reverse;
		}
	}

	public static void main(String a[]) {
		StringRecursiveReversal srr = new StringRecursiveReversal();
		System.out.println("Result: " + srr.reverseString("Java2novice"));
	}
	
}