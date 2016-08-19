package com.ibm.mom.dp.abstract_factory;

public class ConcreteFactory1 implements Factory1 {

	@Override
	public ProductA getProductA1() {
		return new ConcreteProductA1();
	}

	@Override
	public ProductB getProductB1() {
		return new ConcreteProductB1();
	}

}
