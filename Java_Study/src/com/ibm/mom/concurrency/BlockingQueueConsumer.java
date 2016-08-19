package com.ibm.mom.concurrency;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueConsumer implements Runnable {
	protected BlockingQueue<String> blockingQueue;

	public BlockingQueueConsumer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		try {
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
