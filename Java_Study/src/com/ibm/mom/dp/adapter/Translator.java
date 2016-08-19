package com.ibm.mom.dp.adapter;

public class Translator extends Player {
	private ChineseCenter cc = new ChineseCenter();

	public Translator(String name) {
		super(name);
		cc.setName(name);
	}

	@Override
	protected void attack() {
		cc.jingong();
	}

	@Override
	protected void defence() {
		cc.fangshou();
	}
	
}
