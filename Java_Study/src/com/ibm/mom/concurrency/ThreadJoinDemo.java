package com.ibm.mom.concurrency;

public class ThreadJoinDemo {

	public static void main(String[] args) throws InterruptedException {
		MyThread3 my = new MyThread3();
		Thread t1 = new Thread(my, "t1");
		t1.start();

		for (int i = 0; i < 20; i++) {
			System.out.println("main-" + i);
			if (i == 5) {
				t1.join();
//				t1.join(1000);
			}
			Thread.sleep(200);
		}
	}

}

class MyThread3 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-" + i);
		}

	}
}