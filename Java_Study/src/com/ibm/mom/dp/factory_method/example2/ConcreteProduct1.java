package com.ibm.mom.dp.factory_method.example2;

public class ConcreteProduct1 implements Product {

	public ConcreteProduct1() {
		System.out.println("ConcreteProduct1 is created.");
	}

	@Override
	public void printName() {
		System.out.println("This is ConcreteProduct1.");
	}

}
