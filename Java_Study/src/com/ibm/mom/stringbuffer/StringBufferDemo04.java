package com.ibm.mom.stringbuffer;

public class StringBufferDemo04 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("Hello World!!!0123456789");
		String str = sb.reverse().toString();

		System.out.println(str);
		System.out.println(sb);
	}

}
