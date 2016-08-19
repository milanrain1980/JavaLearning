package com.ibm.mom.stringbuffer;

public class StringBufferDemo01 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Hello ").append("World ").append("!!!").append("\n");
		sb.append("Êý×Ö = ").append(1).append("\n");
		sb.append("×Ö·û = ").append('C').append("\n");
		sb.append("²¼¶û = ").append(true);
		
		System.out.println(sb);
	}

}
