package com.ibm.mom.reflection;

public class GetClassDemo01 {

	public static void main(String[] args) {
		X x = new X();
		System.out.println(x.getClass().getName());
		System.out.println(x.getClass().getCanonicalName());
		System.out.println(x.getClass().getPackage().getName());
	}

}

class X {}
