package com.ibm.mom.enumeration;

import org.junit.Before;
import org.junit.Test;

public class EnumColorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(EnumColor1.RED);
		System.out.println(EnumColor1.GREEN);
		System.out.println(EnumColor1.BLUE);
		
		System.out.println("----------------------------------------------");
		
		System.out.println(EnumColor2.RED.getColor());
		System.out.println(EnumColor2.GREEN.getColor());
		System.out.println(EnumColor2.BLUE.getColor());
	}

}
