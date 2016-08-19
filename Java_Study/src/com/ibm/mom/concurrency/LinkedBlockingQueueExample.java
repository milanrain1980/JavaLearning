package com.ibm.mom.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample {

	public static void main(String[] args) throws Exception {
		BlockingQueue<String> unbounded = new LinkedBlockingQueue<String>();
		BlockingQueue<String> bounded   = new LinkedBlockingQueue<String>(1024);

		bounded.put("Value1");

		String value = bounded.take();
		System.out.println(value);
	}

}
