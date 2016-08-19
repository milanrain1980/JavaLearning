package com.ibm.mom.generics;

public class Point<T> {
	private T X;
	private T Y;
	
	public Point(T x, T y) {
		super();
		X = x;
		Y = y;
	}

	public T getX() {
		return X;
	}

	public void setX(T x) {
		X = x;
	}

	public T getY() {
		return Y;
	}

	public void setY(T y) {
		Y = y;
	}
	
}
