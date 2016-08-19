package com.ibm.mom.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample2 {
	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(100);

		BlockingQueueProducer queueProducer = new BlockingQueueProducer(blockingQueue);
		BlockingQueueConsumer queueConsumer = new BlockingQueueConsumer(blockingQueue);

		new Thread(queueProducer).start();
		new Thread(queueConsumer).start();
	}

}
