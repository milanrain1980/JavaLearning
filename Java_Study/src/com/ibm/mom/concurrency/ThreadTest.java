package com.ibm.mom.concurrency;

class Counter {
	int count = 0;

	public synchronized void  add(int value) {
		this.count += value;
		System.out.println("count value is: " + count);
	}
}

class CounterThread extends Thread {
	protected Counter counter = null;

	public CounterThread(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName());
			counter.add(i);
		}
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);
		threadA.setName("threadA");
		threadB.setName("threadB");
		threadA.start();
		threadB.start();
	}
}
