package com.ibm.mom.dp.adapter;

public class ChineseCenter {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void jingong() {
		System.out.println(name + " 正在进攻！");
	}
	
	public void fangshou() {
		System.out.println(name + " 正在防守！");
	}
	
}
