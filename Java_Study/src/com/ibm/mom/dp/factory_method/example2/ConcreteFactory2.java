package com.ibm.mom.dp.factory_method.example2;

public class ConcreteFactory2 implements Factory {

	@Override
	public Product create() {
		return new ConcreteProduct2();
	}

}
