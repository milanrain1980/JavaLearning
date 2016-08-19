package com.ibm.mom.dp.builder;

public class ConcreteBuilder1 extends Builder {
	Product p = new Product();

	@Override
	public void buildPartA() {
		p.add("Part A");
	}

	@Override
	public void buildPartB() {
		p.add("Part B");
	}

	@Override
	public Product getResult() {
		return p;
	}

}
