package com.ibm.mom.reflection;

public class RealSubject implements Subject {

	@Override
	public String say(String name, int age) {
		return "Name: " + name + ", Age: " + age;
	}

}
