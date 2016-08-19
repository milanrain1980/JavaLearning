package com.ibm.mom.concurrency;

class Counter1 {
	private long count = 0;

	public synchronized void add(long value) {
		this.count += value;
		System.out.println(Thread.currentThread().getName() + "==========" + this.count);
	}

	public long get() {
		return this.count;
	}
}

class CounterThread1 extends Thread {
	private Counter1 counter = null;

	public CounterThread1(Counter1 counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			counter.add(i);
		}
	}
}

public class ConcurrencyExample {
	public static void main(String[] args) throws InterruptedException {
		Counter1 counter = new Counter1();
		Thread threadA = new CounterThread1(counter);
		Thread threadB = new CounterThread1(counter);

		threadA.start();
		threadB.start();

		Thread.sleep(500);
		
		System.out.println("Total Number: " + counter.get());
	}
}
