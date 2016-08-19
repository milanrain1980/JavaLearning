package com.ibm.mom.stringbuffer;

public class StringBufferDemo06 {

	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer();
		buf.append("Hello World!!!");
		buf.replace(6, 11, "LI GANG");
		String str = buf.substring(6);
		
		System.out.println("Content is: " + str);
	}

}
