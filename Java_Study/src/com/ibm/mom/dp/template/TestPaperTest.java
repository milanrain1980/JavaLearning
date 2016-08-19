package com.ibm.mom.dp.template;

import org.junit.Before;
import org.junit.Test;

public class TestPaperTest {
	private TestPaper s1, s2;

	@Before
	public void setUp() throws Exception {
		s1 = new Student1("Zhangsan");
		s2 = new Student2("Lisi");
	}

	@Test
	public void test() {
		s1.showPaper("A", "C");
		System.out.println("==================================================");
		s2.showPaper("B", "D");
	}

}
