package com.ibm.mom.concurrency;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanExample {
	public static void main(String[] args) {
		AtomicBoolean atomicBoolean = new AtomicBoolean(false);

		boolean expectedValue = false;
		boolean newValue = true;

		boolean wasNewValueSet = atomicBoolean.compareAndSet(expectedValue, newValue);
		System.out.println(wasNewValueSet);
	}
}
