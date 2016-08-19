package com.ibm.mom.dp.simple_factory;

import org.junit.Before;
import org.junit.Test;

public class UnitTest {
	private double a, b;
	private Operation Add, Minus, Multiply, Divide;
	
	@Before
	public void setup() {
		this.a = 100d;
		this.b = 25d;
		Add = OperationFactory.createOperation(this.a, this.b, Symbol.ADD);
		Minus = OperationFactory.createOperation(this.a, this.b, Symbol.MINUS);
		Multiply = OperationFactory.createOperation(this.a, this.b, Symbol.MULTIPLY);
		Divide = OperationFactory.createOperation(this.a, this.b, Symbol.DIVIDE);
	}
	
	@Test
	public void testAdd() {
		double result = Add.getResult();
		System.out.println("Add result is: " + result);
	}
	
	@Test
	public void testMinus() {
		this.a = 200d;
		this.b = 30d;
		double result = Minus.getResult();
		System.out.println("Minus result is: " + result);
	}
	
	@Test
	public void testMultiply() {
		double result = Multiply.getResult();
		System.out.println("Multiply result is: " + result);
	}
	
	@Test
	public void testDivide() {
		double result = Divide.getResult();
		System.out.println("Divide result is: " + result);
	}
}
