package com.ibm.mom.dp.builder;

public class Director {
	public void construct(Builder builder) {
		builder.buildPartA();
		builder.buildPartB();
	}
}
