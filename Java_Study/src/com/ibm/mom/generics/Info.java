package com.ibm.mom.generics;

public class Info<T> {
	private T var;

	public Info(T var) {
		super();
		this.var = var;
	}

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}

	@Override
	public String toString() {
		return "Info [var=" + var + "]";
	}
	
}
