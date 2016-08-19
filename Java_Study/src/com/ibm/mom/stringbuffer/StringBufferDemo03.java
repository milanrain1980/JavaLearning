package com.ibm.mom.stringbuffer;

public class StringBufferDemo03 {

	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer();
		buf.append("World!!!");
		buf.insert(0, "Hello ");
		System.out.println(buf);
		buf.insert(buf.length(), "IBM~");
		System.out.println(buf);
	}

}
