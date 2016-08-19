package com.ibm.mom.reflection;

public class GetClassDemo02 {

	public static void main(String[] args) {
		Class<?> c1 = null;
		Class<?> c2 = null;
		Class<?> c3 = null;

		try {
			c1 = Class.forName("com.ibm.mendocino.reflection.X");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		c2 = new X().getClass();
		c3 = X.class;

		System.out.println("Class name is: " + c1.getName());
		System.out.println("Class name is: " + c2.getName());
		System.out.println("Class name is: " + c3.getName());
	}

}
