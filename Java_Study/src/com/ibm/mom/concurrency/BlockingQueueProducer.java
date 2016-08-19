package com.ibm.mom.concurrency;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducer implements Runnable {

	protected BlockingQueue<String> blockingQueue;

	public BlockingQueueProducer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			System.out.println("one is added into the Queue.");
			blockingQueue.put("Lion");
			Thread.sleep(1000);
			System.out.println("one is added into the Queue.");
			blockingQueue.put("Crocodile");
			Thread.sleep(2000);
			System.out.println("one is added into the Queue.");
			blockingQueue.put("Jaguar");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}



