package com.ibm.mom.stringbuffer;

public class StringBufferDemo01 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Hello ").append("World ").append("!!!").append("\n");
		sb.append("���� = ").append(1).append("\n");
		sb.append("�ַ� = ").append('C').append("\n");
		sb.append("���� = ").append(true);
		
		System.out.println(sb);
	}

}
