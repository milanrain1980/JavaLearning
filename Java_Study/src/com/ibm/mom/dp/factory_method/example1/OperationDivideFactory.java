package com.ibm.mom.dp.factory_method.example1;

public class OperationDivideFactory extends OperationFactory {

	@Override
	public Operation createOperation(double a, double b) {
		return new OperationDivide(a, b);
	}

}
