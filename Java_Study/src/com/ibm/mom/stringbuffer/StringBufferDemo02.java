package com.ibm.mom.stringbuffer;

public class StringBufferDemo02 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("Hello ");
		func(sb);
		System.out.println(sb);
	}

	public static void func(StringBuffer sb) {
		sb.append("IBM ").append("Li Gang");
	}
}
