package com.ibm.mom.generics;

public class GenericsSuperDemo {

	public static void main(String[] args) {
		Info<Object> i1 = new Info<Object>(new Object());
		Info<String> i2 = new Info<String>("Li Gang");
		
		func(i1);
		func(i2);
		
//		Info<Integer> i3 = new Info<Integer>(10);
//		func(i3);
	}

	public static void func(Info<? super String> info) {
		System.out.println("info: " + info);
	}
}
