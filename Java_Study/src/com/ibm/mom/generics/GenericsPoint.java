package com.ibm.mom.generics;

public class GenericsPoint {

	public static void main(String[] args) {
		Point<Integer> p1 = new Point<Integer>(10, 20);
		Integer x1 = p1.getX();
		Integer y1 = p1.getY();
		
		System.out.println("X axis is:" + x1);
		System.out.println("Y axis is:" + y1);		
		
		Point<Float> p2 = new Point<Float>(10.0f, 20.0f);
		Float x2 = p2.getX();
		Float y2 = p2.getY();
		
		System.out.println("X axis is:" + x2);
		System.out.println("Y axis is:" + y2);		
	}

}
