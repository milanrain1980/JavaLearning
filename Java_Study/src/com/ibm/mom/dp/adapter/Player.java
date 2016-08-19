package com.ibm.mom.dp.adapter;

public abstract class Player {
	protected String name;

	public Player(String name) {
		this.name = name;
	}

	protected abstract void attack();
	
	protected abstract void defence();
	
}
