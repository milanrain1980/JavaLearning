package com.ibm.mom.dp.singleton;

import org.junit.Before;
import org.junit.Test;

public class SingletonTest {
	Singleton s1, s2, s3;

	@Before
	public void setUp() throws Exception {
		s1 = Singleton.getInstance();
		s2 = Singleton.getInstance();
		s3 = Singleton.getInstance();
	}

	@Test
	public void test() {
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
