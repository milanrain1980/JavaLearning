package com.ibm.mom.dp.factory_method.example1;

public class OperationMultiplyFactory extends OperationFactory {

	@Override
	public Operation createOperation(double a, double b) {
		return new OperationMultiply(a, b);
	}

}
