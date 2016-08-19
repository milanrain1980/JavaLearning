package com.ibm.mom.dp.abstract_factory;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		// 厂商1负责生产产品A1、B1
		Factory1 factory1 = new ConcreteFactory1();
		ProductA productA1 = factory1.getProductA1();
		ProductB productB1 = factory1.getProductB1();

		productA1.method();
		productB1.method();

		System.out.println("========================");
		
		// 厂商2负责生产产品A2、B2
		Factory2 factory2 = new ConcreteFactory2();
		ProductA productA2 = factory2.getProductA2();
		ProductB productB2 = factory2.getProductB2();

		productA2.method();
		productB2.method();
	}

}
