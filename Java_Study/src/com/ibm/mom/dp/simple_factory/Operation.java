package com.ibm.mom.dp.simple_factory;

enum Symbol {
	ADD, MINUS, MULTIPLY, DIVIDE
	/*
	 * ADD("+", 1), MINUS("-", 2), MULTIPLY("*", 3), DIVIDE("/", 4)
	 */
}

public abstract class Operation {
	protected double d1;
	protected double d2;
	protected Symbol s;
	
	public Operation(double d1, double d2, Symbol s) {
		this.d1 = d1;
		this.d2 = d2;
		this.s = s;
	}

	public abstract double getResult();
}
