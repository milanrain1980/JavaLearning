package com.ibm.mom.inheritance;

class Parent {}

class Sub extends Parent {}

class A {
	public void fun(Parent p) {
		System.out.println("A");
	}
}

class B extends A {
	public void fun(Sub s) {
		System.out.println("B");
	}
}

public class InheritTest {
	public static void main(String[] args) {
		Sub s = new Sub();
		Parent p = s;
		B b = new B();
		A a = b;

		a.fun(p);
		a.fun(s);
		b.fun(p);
		b.fun(s);
	}
}
