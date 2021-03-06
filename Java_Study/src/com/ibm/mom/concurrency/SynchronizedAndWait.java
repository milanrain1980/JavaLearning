package com.ibm.mom.concurrency;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Nested synchronized blocks with wait() and notify()
 *
 *Calling wait() on an object monitor only frees the lock on this object monitor. 
 *Other locks which are being hold by the same thread are not freed. 
 *As this is easy to understand, it may happen in day-to-day work that the thread that calls wait() holds further locks. 
 *And if other threads are also waiting for these locks a deadlock situation can happen.
 *
 *Adding synchronized to the method signature is equal to creating a synchronized(this){} block. 
 *In this example we have accidentally added the synchronized keyword to the method and afterwards synchronized 
 *on the object monitor queue in order to put the current thread into sleep while waiting for the next value from the queue. 
 *The current thread then releases the lock hold on queue but not the lock hold on this. 
 *The putInt() method notifies the sleeping thread that a new value has been added. 
 *But accidentally we have also added the keyword synchronized to this method. 
 *When now the second thread has fallen asleep, it still holds the lock. 
 *The first thread can then not enter the method putInt() as the this lock is hold by the first thread. 
 *Hence we have a deadlock situation and the program hangs. 
 *If you execute the code below, this happens right after the beginning of the program.
 */
public class SynchronizedAndWait {
	private static final Queue<Integer> queue = new ConcurrentLinkedQueue<Integer>();

	public synchronized Integer getNextInt() {
		Integer retVal = null;
		while (retVal == null) {
			synchronized (queue) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				retVal = queue.poll();
			}
		}
		return retVal;
	}

	public synchronized void putInt(Integer value) {
		synchronized (queue) {
			queue.add(value);
			queue.notify();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final SynchronizedAndWait queue = new SynchronizedAndWait();
		
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					queue.putInt(i);
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					Integer nextInt = queue.getNextInt();
					System.out.println("Next int: " + nextInt);
				}
			}
		});
		
		thread1.start();
		thread2.start();
//		thread1.join();
//		thread2.join();
	}
	
}