package com.ibm.mom.generics;

public class GenericsExtendsDemo {

	public static void main(String[] args) {
		Info<Integer> i1 = new Info<Integer>(30);
		Info<Float> i2 = new Info<Float>(30.2222f);
		
		func(i1);
		func(i2);

//		Info<String> i3 = new Info<String>("hello");
//		func(i3);
	}

	public static void func(Info<? extends Number> info) {
		System.out.println(info + ",");
	}
	
}
