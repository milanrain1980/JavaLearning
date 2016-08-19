package com.ibm.mom.dp.observer.example;

/**
 * ����Ĺ۲��߶���
 * 
 * @author ligang
 *
 */
public class Person implements Observer {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	@Override
	public void update(float price) {
		System.out.println(this.name + "��ע�����޼۸����Ϊ: " + price);
	}

}
