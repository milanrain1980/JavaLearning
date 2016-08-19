package com.ibm.mom.dp.adapter;

public class Forward extends Player {

	public Forward(String name) {
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
