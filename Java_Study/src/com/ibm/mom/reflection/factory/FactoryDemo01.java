package com.ibm.mom.reflection.factory;

public class FactoryDemo01 {

	public static void main(String[] args) {
		Fruit f = Factory.getInstance(Apple.class.getName());
		if (f != null) {
			f.eat();
		}
	}

}
