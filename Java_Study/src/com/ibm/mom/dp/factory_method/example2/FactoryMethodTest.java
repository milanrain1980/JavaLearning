package com.ibm.mom.dp.factory_method.example2;

public class FactoryMethodTest {

	public static void main(String[] args) {
		Factory f1 = new ConcreteFactory1();
		Factory f2 = new ConcreteFactory2();
		Product p1 = f1.create();
		Product p2 = f2.create();
		System.out.println("========================");
		
		p1.printName();
		p2.printName();
	}

}
