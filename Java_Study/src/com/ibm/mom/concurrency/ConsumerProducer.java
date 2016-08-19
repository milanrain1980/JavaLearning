package com.ibm.mom.concurrency;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * The wait() method that every object inherits from the java.lang.Object class 
 * can be used to pause the current thread execution and 
 * wait until another threads wakes us up using the notify() method. 
 * In order to work correctly, the thread that calls the wait() method 
 * has to hold a lock that it has acquired before using the synchronized keyword. 
 * When calling wait() the lock is released and the threads waits until another thread 
 * that now owns the lock calls notify() on the same object instance.
 */

public class ConsumerProducer {
	private static final Queue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	private static final long startMillis = System.currentTimeMillis();

	public static class Consumer implements Runnable {
		@Override
		public void run() {
			while (System.currentTimeMillis() < (startMillis + 10000)) {
				synchronized (queue) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (!queue.isEmpty()) {
//				System.out.println("[queue.isEmpty()?]: " + queue.isEmpty());				
					Integer integer = queue.poll();
					System.out.println("[" + Thread.currentThread().getName() + "]: " + integer);
				}
			}
		}
	}

	public static class Producer implements Runnable {
		private static int count = 0;
		
		@Override
		public void run() {
			while (System.currentTimeMillis() < (startMillis + 10000)) {
				synchronized (queue) {
					queue.add(count++);
					queue.notify();
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
/*			synchronized (queue) {
				queue.notifyAll();
			}*/
		}

	}

	
	/**
	 * The main() method starts five consumer and one producer thread and then waits for them to finish. 
	 * The producer thread then inserts a new value into the queue 
	 * and afterwards notifies all waiting threads that something has happened. 
	 * The consumer threads acquire the queue lock and then fall asleep in order to be woken up later 
	 * on when the queue is filled again. 
	 * When the producer thread has finished its work, it notifies all consumer threads to wake up. 
	 * If we won’t do the last step, the consumer threads would wait forever for the next notification, 
	 * as we haven’t specified any timeout for the waiting. 
	 * Instead we could have used the method wait(long timeout) to be woken up 
	 * at least after some amount of time has passed by.
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread[] consumerThreads = new Thread[5];
		for (int i = 0; i < consumerThreads.length; i++) {
			consumerThreads[i] = new Thread(new Consumer(), "consumer-" + i);
			consumerThreads[i].start();
		}
		
		Thread[] producerThreads = new Thread[3];
		for (int i = 0; i < producerThreads.length; i++) {
			producerThreads[i] = new Thread(new Producer(), "producer-" + i);
			producerThreads[i].start();
		}
		
/*		Thread producerThread = new Thread(new Producer(), "producer");
		producerThread.start();*/
		
/*		for (int i = 0; i < consumerThreads.length; i++) {
			consumerThreads[i].join();
		}
		producerThread.join();*/
	}
	
}
