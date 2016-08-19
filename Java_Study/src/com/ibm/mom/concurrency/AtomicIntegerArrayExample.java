package com.ibm.mom.concurrency;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayExample {

	public static void main(String[] args) {
		int newValue = 0;
		int oldValue = 0;
//		AtomicIntegerArray array = new AtomicIntegerArray(10);

		int[] ints = new int[10];
		ints[5] = 123;
		AtomicIntegerArray array = new AtomicIntegerArray(ints);
		
		int value = array.get(5);
		
		array.set(5, 999);
		
		boolean swapped = array.compareAndSet(5, 999, 123);

		newValue = array.addAndGet(5, 3);

		oldValue = array.getAndAdd(5, 3);

		newValue = array.incrementAndGet(5);

		oldValue = array.getAndIncrement(5);

		newValue = array.decrementAndGet(5);

		oldValue = array.getAndDecrement(5);
	}

}
