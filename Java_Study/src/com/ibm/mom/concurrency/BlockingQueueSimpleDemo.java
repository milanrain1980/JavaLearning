package com.ibm.mom.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueSimpleDemo {
	
	public static void main(String[] args) throws Exception {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);

		ProducerDemo producer = new ProducerDemo(queue);
		ConsumerDemo consumer = new ConsumerDemo(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}
}

class ProducerDemo implements Runnable {
	protected BlockingQueue<String> queue = null;

	public ProducerDemo(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			queue.put("1");
			System.out.println("Put in the queue - 1");
			Thread.sleep(1000);
			queue.put("2");
			System.out.println("Put in the queue - 2");
			Thread.sleep(1000);
			queue.put("3");
			System.out.println("Put in the queue - 3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ConsumerDemo implements Runnable {
	protected BlockingQueue<String> queue = null;

	public ConsumerDemo(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			System.out.println("Take from the queue - " + queue.take());
			System.out.println("Take from the queue - " + queue.take());
			System.out.println("Take from the queue - " + queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}