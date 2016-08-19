package com.ibm.mom.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * The PriorityBlockingQueue is an unbounded concurrent queue. 
 * It uses the same ordering rules as the java.util.PriorityQueue class. You cannot insert null into this queue. 
 *
 *All elements inserted into the PriorityBlockingQueue must implement the java.lang.Comparable interface. 
 *The elements thus order themselves according to whatever priority you decide in your Comparable implementation. 
 */
public class PriorityBlockingQueueExample {

	public static void main(String[] args) throws Exception {
		BlockingQueue<String> queue   = new PriorityBlockingQueue<String>();

	    //String implements java.lang.Comparable
	    queue.put("Value");

	    String value = queue.take();

	}

}
