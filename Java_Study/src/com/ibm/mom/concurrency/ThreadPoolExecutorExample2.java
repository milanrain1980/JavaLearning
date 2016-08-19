package com.ibm.mom.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorExample2 implements Runnable {
	private static AtomicInteger counter = new AtomicInteger();
	private final int taskId;

	public int getTaskId() {
		return taskId;
	}

	public ThreadPoolExecutorExample2(int taskId) {
		this.taskId = taskId;
	}

	@Override
	public void run() {
		try {
			System.out.println("====================" + Thread.currentThread().getName() + " Begin to sleep for 5 secs...====================");
			Thread.sleep(5000);
			System.out.println("====================" + Thread.currentThread().getName() + " Wait up from sleeping...====================");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(10);
		
		ThreadFactory threadFactory = new ThreadFactory() {
			public Thread newThread(Runnable r) {
				int currentCount = counter.getAndIncrement();
				System.out.println("Creating new thread: " + currentCount);
				return new Thread(r, "mythread" + currentCount);
			}
		};
		
		RejectedExecutionHandler rejectedHandler = new RejectedExecutionHandler() {
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				if (r instanceof ThreadPoolExecutorExample2) {
					ThreadPoolExecutorExample2 example = (ThreadPoolExecutorExample2) r;
					System.out.println("Rejecting task with id " + example.getTaskId());
				}
			}
		};
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, queue, threadFactory, rejectedHandler);
		
		for (int i = 0; i < 100; i++) {
			System.out.println("====================for loop: ====================" + i);
			executor.execute(new ThreadPoolExecutorExample2(i));
		}
		
		executor.shutdown();
//		executor.shutdownNow();
	}
	
}
