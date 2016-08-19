package com.ibm.mom.dp.observer.example;

import java.util.Observable;

public class Doll2 extends Observable {
	private float price;

	public Doll2(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
		this.setChanged();						// ֪ͨ�����Ѿ��ı�
		this.notifyObservers();  			// ֪ͨ�۲���
//		this.notifyObservers(null);      //����в������ô˷���֪ͨ�۲���
	}
	
}
