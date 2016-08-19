package com.ibm.mom.concurrency;

/**
 * Scope reduction:
 * This can be applied when the lock is hold longer than necessary. 
 * Often this can be achieved by moving one or more lines out of the synchronized block 
 * in order to reduce the time the current thread holds the lock. 
 * The less number of lines of code to execute the earlier the current thread can leave the synchronized block 
 * and therewith let other threads acquire the lock.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ReduceLockDuration implements Runnable {
	private static final int NUMBER_OF_THREADS = 5;
	private static final Map<String, Integer> map = new HashMap<String, Integer>();

	// Bad implementation:
/*	public void run() {
		for (int i = 0; i < 100000; i++) {
			synchronized (map) {
				UUID randomUUID = UUID.randomUUID();
				Integer value = Integer.valueOf(42);
				String key = randomUUID.toString();
				map.put(key, value);
			}
			Thread.yield();
		}
	}*/
	
	// Good implementation:
	public void run() {
		for (int i = 0; i < 100000; i++) {
			UUID randomUUID = UUID.randomUUID();
			Integer value = Integer.valueOf(42);
			String key = randomUUID.toString();
			synchronized (map) {
				map.put(key, value);
			}
			Thread.yield();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[NUMBER_OF_THREADS];
		for (int i = 0; i < NUMBER_OF_THREADS; i++) {
			threads[i] = new Thread(new ReduceLockDuration());
		}
		long startMillis = System.currentTimeMillis();
		for (int i = 0; i < NUMBER_OF_THREADS; i++) {
			threads[i].start();
		}
		for (int i = 0; i < NUMBER_OF_THREADS; i++) {
			threads[i].join();
		}
		System.out.println((System.currentTimeMillis() - startMillis) + "ms");
	}
	
}
