package com.ibm.mom.concurrency;

public class ThreadDaemonDemo {

	public static void main(String[] args) {
		MyThread6 my6 = new MyThread6();
		Thread t1 = new Thread(my6, "t1");
		t1.setDaemon(true);
		t1.start();
		for (int i=0;i<10; i++) {
			if (i==5) {
				Thread.yield();
			}
			System.out.println("main-" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class MyThread6 implements Runnable {

	@Override
	public void run() {
		for (int i =0; i<50; i++) {
			System.out.println(Thread.currentThread().getName() + "-" +i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
