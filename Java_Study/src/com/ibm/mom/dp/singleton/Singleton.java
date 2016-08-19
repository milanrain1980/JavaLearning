package com.ibm.mom.dp.singleton;

public class Singleton {
	private Singleton() {}
	
	// Eager Singleton
/*	private static Singleton instance = new Singleton();
	
	public static Singleton getInstance() {
		return instance;
	}*/
	
	// Lazy Singleton
	private static Singleton instance;
	
	public synchronized static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		
		return instance;
	}
}
