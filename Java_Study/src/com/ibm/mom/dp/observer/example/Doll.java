package com.ibm.mom.dp.observer.example;

import java.util.Vector;

/**
 * ����ı��۲�����
 * 
 * @author ligang
 *
 */
public class Doll implements Subject {
	private Vector<Observer> v = new Vector<Observer>();
	private float price;
	
	public Doll(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		// �޸ļ۸�ʱ��֪ͨ���й۲���
		this.price = price;
		this.notifyObservers();
	}

	@Override
	public void registerObserver(Observer o) {
		v.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		v.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer o : v) {
			o.update(price);
		}
	}

}
