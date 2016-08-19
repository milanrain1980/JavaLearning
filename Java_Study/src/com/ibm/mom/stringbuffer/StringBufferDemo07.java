package com.ibm.mom.stringbuffer;

public class StringBufferDemo07 {

	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer();
		buf.append("Hello World!!!");
		buf.replace(6, 11, "LI GANG");
		String str = buf.delete(6, 13).toString();
		
		System.out.println("Content is: " + str);
	}

}
