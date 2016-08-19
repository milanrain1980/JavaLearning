package com.ibm.mom.reflection;

public class ClassLoaderDemo {

	public static void main(String[] args) {
		Person p = new Person("LI GANG", 34);
		System.out.println(p.getClass().getClassLoader());
	}

}
