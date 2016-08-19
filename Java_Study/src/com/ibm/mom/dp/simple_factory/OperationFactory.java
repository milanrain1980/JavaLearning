package com.ibm.mom.dp.simple_factory;

public class OperationFactory {

	public static Operation createOperation(double a, double b, Symbol s) {
		Operation oper = null;

		if (null == s) {
			return null;
		} else {
			if (s.equals(Symbol.ADD)) {
				oper = new OperationAdd(a, b, s);
			} else if (s.equals(Symbol.MINUS)) {
				oper = new OperationMinus(a, b, s);
			} else if (s.equals(Symbol.MULTIPLY)) {
				oper = new OperationMultiply(a, b, s);
			} else {
				oper = new OperationMinus(a, b, s);
			}

			return oper;
		}
	}
}
