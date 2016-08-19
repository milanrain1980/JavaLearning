package com.ibm.mom.reflection.factory;

public class Factory {
	public static Fruit getInstance(String className) {
		Fruit fruit = null;
		
		try {
			fruit = (Fruit) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fruit;
	}
}
