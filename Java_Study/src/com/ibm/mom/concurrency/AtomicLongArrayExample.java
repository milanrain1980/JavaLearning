package com.ibm.mom.concurrency;

import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicLongArrayExample {

	public static void main(String[] args) {
		long newValue = 0;
		long oldValue = 0;
//		AtomicLongArray array = new AtomicLongArray(10);

		long[] longs = new long[10];
		longs[5] = 123;
		AtomicLongArray array = new AtomicLongArray(longs);
		
		long value = array.get(5);

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
