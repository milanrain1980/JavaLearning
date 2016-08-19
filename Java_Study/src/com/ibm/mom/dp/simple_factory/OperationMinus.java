package com.ibm.mom.dp.simple_factory;

public class OperationMinus extends Operation {

	public OperationMinus(double d1, double d2, Symbol s) {
		super(d1, d2, s);
	}

	@Override
	public double getResult() {
		return this.d1 - this.d2;
	}

}
