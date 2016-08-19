package com.ibm.mom.concurrency;

public class OrderedThreadsTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new OrderedThread(), "A");
		Thread t2 = new Thread(new OrderedThread(), "B");
		Thread t3 = new Thread(new OrderedThread(), "C");
		t1.start();
//		t1.join();
		t2.start();
//		t2.join();
		t3.start();
	}

}

class OrderedThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
