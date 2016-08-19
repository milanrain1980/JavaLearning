package com.ibm.mom.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Semaphores are used to control access to a shared resource. 
 * In contrast to simple synchronized blocks a semaphore has an internal counter 
 * that is increased each time a thread acquires a lock and decreased each time a thread releases a lock it obtained before. 
 * The increasing and decreasing operations are of course synchronized, 
 * hence a semaphore can be used to control how many threads pass simultaneously through a critical section. 
 * 
 * To illustrate the described behavior, let’s setup a simple thread pool with five threads 
 * but control through a semaphore that at each point in time not more than three of them are running:
 */
public class SemaphoreExample implements Runnable {
	private static final Semaphore semaphore = new Semaphore(3, true);
	private static final AtomicInteger counter = new AtomicInteger();
	private static final long endMillis = System.currentTimeMillis() + 10000;

	@Override
	public void run() {
		while(System.currentTimeMillis() < endMillis) {
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				System.out.println("["+Thread.currentThread().getName()+"] Interrupted in acquire().");
			}
			int counterValue = counter.incrementAndGet();
			System.out.println("["+Thread.currentThread().getName()+"] semaphore acquired: "+counterValue);
			if(counterValue > 3) {
				throw new IllegalStateException("More than three threads acquired the lock.");
			}
			counter.decrementAndGet();
			semaphore.release();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			executorService.execute(new SemaphoreExample());
		}
		executorService.shutdown();
	}
	
}
