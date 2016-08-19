package com.ibm.mom.dp.factory_method.example2;

public class ConcreteFactory1 implements Factory {

	@Override
	public Product create() {
		return new ConcreteProduct1();
	}

}
