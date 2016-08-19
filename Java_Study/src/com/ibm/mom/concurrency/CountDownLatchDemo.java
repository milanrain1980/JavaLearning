package com.ibm.mom.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) throws Exception {
		CountDownLatch latch = new CountDownLatch(3);

		Waiter waiter = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);

		new Thread(waiter).start();
		new Thread(decrementer).start();

		Thread.sleep(4000);
	}
}

class Waiter implements Runnable {
	private CountDownLatch latch = null;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			System.out.println("Waiter run...");
			latch.await();
			System.out.println("Waiter to be released at once...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Waiter Released");
	}
}

class Decrementer implements Runnable {
	private CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("CountDownLatch minus one...");

			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("CountDownLatch minus one...");

			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("CountDownLatch minus one...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
