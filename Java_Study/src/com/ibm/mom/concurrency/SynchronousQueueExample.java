package com.ibm.mom.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * The SynchronousQueue is a queue that can only contain a single element internally. 
 * A thread inseting an element into the queue is blocked until another thread takes that element from the queue. 
 * Likewise, if a thread tries to take an element and no element is currently present, that thread is blocked 
 * until a thread insert an element into the queue.  
 *
 */
public class SynchronousQueueExample {

	public static void main(String[] args) throws Exception {
		BlockingQueue<String> queue   = new SynchronousQueue<String>();
		
	    queue.put("Value1");

	    String value = queue.take();
	}

}
