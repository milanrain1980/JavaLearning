package com.ibm.mom.object;

public class BoxingTest {

	public static void main(String[] args) {
		Integer a = null;
		System.out.println("a= " + a);
/*		int b = a;
		System.out.println("b= " + b);*/
		
		Integer i = 1000;
		Integer j = 1000;
		System.out.println("i==j: " + (i == j));
		System.out.println("i.equals(j): " + i.equals(j));
	}

}
