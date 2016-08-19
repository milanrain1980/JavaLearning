package com.ibm.mom.dp.factory_method.example2;

public class ConcreteProduct2 implements Product {

	public ConcreteProduct2() {
		System.out.println("ConcreteProduct2 is created.");
	}

	@Override
	public void printName() {
		System.out.println("This is ConcreteProduct2.");
	}

}
