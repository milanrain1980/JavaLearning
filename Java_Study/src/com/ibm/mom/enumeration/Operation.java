package com.ibm.mom.enumeration;

public enum Operation {
	ADD("+") {
		@Override
		double getResult(double a, double b) {
			return a + b;
		}
	},
	MINUS("-") {
		@Override
		double getResult(double a, double b) {
			return a - b;
		}
	},
	MULTIPLE("*") {
		@Override
		double getResult(double a, double b) {
			return a * b;
		}
	},
	DIVIDE("/") {
		@Override
		double getResult(double a, double b) {
			return a / b;
		}
	};

	abstract double getResult(double a, double b);
	
	private String symbol;
	
	private Operation(String symbol) {
		this.symbol = symbol;
	}
	


	public static void main(String...strings) {
		double a = 10.0;
		double b= 5.0;
		System.out.println(Operation.ADD.getResult(a, b));
		System.out.println(Operation.MINUS.getResult(a, b));
		System.out.println(Operation.MULTIPLE.getResult(a, b));
		System.out.println(Operation.MINUS.getResult(a, b));
		System.out.println("======================================");
		System.out.println(ADD);
	}
}
