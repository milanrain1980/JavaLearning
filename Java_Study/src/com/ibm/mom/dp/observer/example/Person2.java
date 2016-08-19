package com.ibm.mom.dp.observer.example;

import java.util.Observable;
import java.util.Observer;

/**
 * ͨ��java.util.Observer�ӿ�ʵ��
 * 
 * @author ligang
 *
 */
public class Person2 implements Observer {
	private String name;
	
	public Person2(String name) {
		this.name = name;
	}
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Doll2) {
			Doll2 doll = (Doll2) o;
			System.out.println(this.name + "��ע�ļ۸��Ѿ�����Ϊ" + doll.getPrice());
		}
	}

}
