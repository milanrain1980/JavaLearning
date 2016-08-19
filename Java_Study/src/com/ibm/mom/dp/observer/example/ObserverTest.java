package com.ibm.mom.dp.observer.example;

import org.junit.Before;
import org.junit.Test;

public class ObserverTest {
	private Doll doll;
	private Observer p1;
	private Observer p2;
	
	@Before
	public void setUp() throws Exception {
		doll = new Doll(3000);
		p1 = new Person("Bill");
		p2 = new Person("Howard");
	}

	@Test
	public void test() {
		doll.registerObserver(p1);
		doll.registerObserver(p2);
		System.out.println("��һ�ִ�����");
		doll.setPrice(2700);
		System.out.println("�ڶ��ִ����� ");
		doll.setPrice(1999);
		System.out.println("Howard���۹����ȡ����ע��");
		doll.removeObserver(p2);
		System.out.println("�����ִ����� ");
		doll.setPrice(1666);
	}

}
