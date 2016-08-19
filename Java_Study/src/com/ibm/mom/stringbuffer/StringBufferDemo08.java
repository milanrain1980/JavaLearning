package com.ibm.mom.stringbuffer;

public class StringBufferDemo08 {

	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer();
		buf.append("Hello World!!!");
		
		if (buf.indexOf("Hello") == -1) {
			System.out.println("Can not find specified content.");
		} else {
			System.out.println("Can find specified content.");
		}
	}

}
