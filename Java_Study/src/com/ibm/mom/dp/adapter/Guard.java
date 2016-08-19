package com.ibm.mom.dp.adapter;

public class Guard extends Player {

	public Guard(String name) {
		super(name);
	}

	@Override
	protected void attack() {
		System.out.println(name + " is attacking...");
	}

	@Override
	protected void defence() {
		System.out.println(name + " is defensing...");
	}

}
