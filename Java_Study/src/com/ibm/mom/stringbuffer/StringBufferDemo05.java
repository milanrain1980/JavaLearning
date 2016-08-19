package com.ibm.mom.stringbuffer;

public class StringBufferDemo05 {

	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer();
		buf.append("Hello ").append("World!!!");
		buf.replace(6,  11,  "Li Gang");
		
		System.out.println(buf);
	}

}
