package com.ibm.mom.dp.builder;

public class ConcreteBuilder2 extends Builder {
	Product p = new Product();

	@Override
	public void buildPartA() {
		p.add("Part X");
	}

	@Override
	public void buildPartB() {
		p.add("Part Y");
	}

	@Override
	public Product getResult() {
		return p;
	}

}
