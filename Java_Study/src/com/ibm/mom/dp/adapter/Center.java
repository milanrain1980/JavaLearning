package com.ibm.mom.dp.adapter;

public class Center extends Player {

	public Center(String name) {
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
