package com.ibm.mom.concurrency;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");
		ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");

		new Thread(exchangerRunnable1).start();
		new Thread(exchangerRunnable2).start();
	}
}

class ExchangerRunnable implements Runnable {
	private Exchanger<String> exchanger = null;
	private String str = null;

	public ExchangerRunnable(Exchanger<String> exchanger, String str) {
		this.exchanger = exchanger;
		this.str = str;
	}

	public void run() {
		try {
			String previous = this.str;
			this.str = this.exchanger.exchange(this.str);
			System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
