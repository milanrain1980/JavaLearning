package com.ibm.mom.generics.pair2;

/**
 * @version 1.00 2004-05-10
 * @author Cay Horstmann
 */
public class Pair<T> {
	private T first;
	private T second;

	public Pair() {
		this.first = null;
		this.second = null;
	}

	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}

	public void setFirst(T newValue) {
		first = newValue;
	}

	public void setSecond(T newValue) {
		second = newValue;
	}
}
