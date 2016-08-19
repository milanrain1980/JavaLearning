package com.ibm.mom.dp.factory_method.example1;

enum Symbol {
	ADD, MINUS, MULTIPLY, DIVIDE
	/*
	 * ADD("+", 1), MINUS("-", 2), MULTIPLY("*", 3), DIVIDE("/", 4)
	 */
}

public abstract class Operation {
	protected double d1;
	protected double d2;
	
	public Operation(double d1, double d2) {
		this.d1 = d1;
		this.d2 = d2;
	}

	public abstract double getResult();
}
