package com.ibm.mom.dp.abstract_factory;

public class ConcreteFactory2 implements Factory2 {

	@Override
	public ProductA getProductA2() {
		return new ConcreteProductA2();
	}

	@Override
	public ProductB getProductB2() {
		return new ConcreteProductB2();
	}

}
