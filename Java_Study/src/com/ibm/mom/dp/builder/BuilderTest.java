package com.ibm.mom.dp.builder;

import org.junit.Before;
import org.junit.Test;

public class BuilderTest {
	private Builder b1, b2;
	private Product p1, p2;

	@Before
	public void setUp() throws Exception {
		b1 = new ConcreteBuilder1();
		b1.buildPartA();
		b1.buildPartB();
		b2 = new ConcreteBuilder2();
		b2.buildPartA();
		b2.buildPartB();
	}

	@Test
	public void test() {
		p1 = b1.getResult();
		p1.show();
		
		p2 = b2.getResult();
		p2.show();
	}

}
