package com.ibm.mom.dp.factory_method.example1;

public class OperationMinus extends Operation {

	public OperationMinus(double d1, double d2) {
		super(d1, d2);
	}

	@Override
	public double getResult() {
		return this.d1 - this.d2;
	}

}
