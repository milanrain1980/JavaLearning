package com.ibm.mom.dp.factory_method.example1;

import org.junit.Before;
import org.junit.Test;

import com.ibm.mom.dp.factory_method.example1.Operation;

public class UnitTest {
	
	private double a, b;
	private Operation addOperation, minusOperation, multiplyOperation, divideOperation;
	
	@Before
	public void setup() {
		this.a = 100d;
		this.b = 25d;
		OperationFactory addFactory = new OperationAddFactory();
		OperationFactory minusFactory = new OperationMinusFactory();
		OperationFactory multiplyFactory = new OperationMultiplyFactory();
		OperationFactory divideFactory = new OperationDivideFactory();
		
		addOperation = addFactory.createOperation(a, b);
		minusOperation = minusFactory.createOperation(a, b);
		multiplyOperation = multiplyFactory.createOperation(a, b);
		divideOperation = divideFactory.createOperation(a, b);
	}
		

	@Test
	public void add() {
		double result = this.addOperation.getResult();
		System.out.println("Add result is: " + result);
		System.out.println("================================");
	}
	
	@Test
	public void minus() {
		double result = this.minusOperation.getResult();
		System.out.println("Minus result is: " + result);
		System.out.println("================================");
	}
	
	@Test
	public void multiply() {
		double result = this.multiplyOperation.getResult();
		System.out.println("Multiply result is: " + result);
		System.out.println("================================");
	}
	
	@Test
	public void divide() {
		double result = this.divideOperation.getResult();
		System.out.println("Divide result is: " + result);
		System.out.println("================================");
	}

}
