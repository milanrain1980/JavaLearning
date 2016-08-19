package com.ibm.mom.concurrency;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Lock splitting:
 * Another technique to reduce lock contention is to split one lock into a number of smaller scoped locks. 
 * This technique can be applied if you have one lock for guarding different aspects of your application. 
 * Assume we want to collect some statistical data about our application and implement a simple counter class 
 * that holds for each aspect a primitive counter variable. 
 * As our application is multi-threaded, we have to synchronize access to these variables, 
 * as they are accessed from different concurrent threads. 
 * The easiest way to accomplish this is to use the synchronized keyword within the method signature 
 * for each method of Counter:
 */
public class LockSplitting implements Runnable {
	public interface Counter {
		void incrementCustomer();

		void incrementShipping();

		long getCustomerCount();

		long getShippingCount();
	}

	
	/**
	 * This approach also means that each increment of a counter locks the whole instance of Counter. 
	 * Other threads that want to increment a different variable have to wait until this single lock is released.
	 */
	public static class CounterOneLock implements Counter {
		private long customerCount = 0;
		private long shippingCount = 0;

		public synchronized void incrementCustomer() {
			customerCount++;
		}

		public synchronized void incrementShipping() {
			shippingCount++;
		}

		public synchronized long getCustomerCount() {
			return customerCount;
		}

		public synchronized long getShippingCount() {
			return shippingCount;
		}
	}


	/**
	 * This implementation introduces two separate synchronization objects, one for each counter. 
	 * Hence a thread trying to increase the number of customers in our system only has to 
	 * compete with other threads that also increment the number of customers 
	 * but it has not to compete with threads trying to increment the number of shipping.
	 */
	public static class CounterSeparateLock implements Counter {
		private static final Object customerLock = new Object();
		private static final Object shippingLock = new Object();
		private long customerCount = 0;
		private long shippingCount = 0;

		public void incrementCustomer() {
			synchronized (customerLock) {
				customerCount++;
			}
		}

		public void incrementShipping() {
			synchronized (shippingLock) {
				shippingCount++;
			}
		}

		public long getCustomerCount() {
			synchronized (customerLock) {
				return customerCount;
			}
		}

		public long getShippingCount() {
			synchronized (shippingLock) {
				return shippingCount;
			}
		}
	}
	
	
	/**
	 * Another possible improvement is to separate locks even more by distinguishing between read and write locks. 
	 * The Counter class for example provides methods for reading and writing the counter value. 
	 * While reading the current value can be done by more than one thread in parallel, 
	 * all write operations have to be serialized. 
	 * The java.util.concurrent package provides a ready to use implementation of such a ReadWriteLock.
	 * 
	 * The ReentrantReadWriteLock implementation manages two separate locks. 
	 * One for read accesses and one for write accesses. 
	 * Both the read and the write lock offer methods for locking and unlocking. 
	 * The write lock is only acquired, if there is no read lock. 
	 * The read lock can be acquired by more than on reader thread, as long as the write lock is not acquired. 
	 * For demonstration purposes the following shows an implementation of the counter class using a ReadWriteLock:
	 * 
	 * All read accesses are guarded by an acquisition of the read lock, 
	 * while all write accesses are guarded by the corresponding write lock. 
	 * In case the application uses much more read than write accesses, 
	 * this kind of implementation can even gain more performance improvement than 
	 * this one as all the reading threads can access the getter method in parallel.
	 */
	public static class CounterReadWriteLock implements Counter {
		private final ReentrantReadWriteLock customerLock = new ReentrantReadWriteLock();
		private final Lock customerWriteLock = customerLock.writeLock();
		private final Lock customerReadLock = customerLock.readLock();
		private final ReentrantReadWriteLock shippingLock = new ReentrantReadWriteLock();
		private final Lock shippingWriteLock = shippingLock.writeLock();
		private final Lock shippingReadLock = shippingLock.readLock();
		private long customerCount = 0;
		private long shippingCount = 0;

		public void incrementCustomer() {
			customerWriteLock.lock();
			customerCount++;
			customerWriteLock.unlock();
		}

		public void incrementShipping() {
			shippingWriteLock.lock();
			shippingCount++;
			shippingWriteLock.unlock();
		}

		public long getCustomerCount() {
			customerReadLock.lock();
			long count = customerCount;
			customerReadLock.unlock();
			return count;
		}

		public long getShippingCount() {
			shippingReadLock.lock();
			long count = shippingCount;
			shippingReadLock.unlock();
			return count;
		}
	}
	
	
	/**
	 * Another way to reduce lock contention is to use so called atomic operations. 
	 * This principle is explained and evaluated in more detail in one of the following articles. 
	 * The java.util.concurrent package offers support for atomic operations for some primitive data types. 
	 * Atomic operations are implemented using the so called compare-and-swap (CAS) operation 
	 * provided by the processor. The CAS instruction only updates the value of a certain register, 
	 * if the current value equals the provided value. Only in this case the old value is replaced by the new value.
	 * 
	 * This principle can be used to increment a variable in an optimistic way. 
	 * If we assume our thread knows the current value, then it can try to increment it by using the CAS operation. 
	 * If it turns out, that another thread has meanwhile incremented the value and our value is no longer the current one, 
	 * we request the current value and try with it again. 
	 * This can be done until we successfully increment the counter. 
	 * The advantage of this implementation, although we may need some spinning, 
	 * is that we don’t need any kind of synchronization.
	 */
	public static class CounterAtomic implements Counter {
		private AtomicLong customerCount = new AtomicLong();
		private AtomicLong shippingCount = new AtomicLong();

		public void incrementCustomer() {
			customerCount.incrementAndGet();
		}

		public void incrementShipping() {
			shippingCount.incrementAndGet();
		}

		public long getCustomerCount() {
			return customerCount.get();
		}

		public long getShippingCount() {
			return shippingCount.get();
		}
	}

	
	private static final int NUMBER_OF_THREADS = 5;
	private Counter counter;

	public LockSplitting(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 1000000; i++) {
			if (ThreadLocalRandom.current().nextBoolean()) {
				counter.incrementCustomer();
			} else {
				counter.incrementShipping();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[NUMBER_OF_THREADS];
//		Counter counter = new CounterOneLock();
//		Counter counter = new CounterSeparateLock();
//		Counter counter = new CounterReadWriteLock();
		Counter counter = new CounterAtomic();		
		
		for (int i = 0; i < NUMBER_OF_THREADS; i++) {
			threads[i] = new Thread(new LockSplitting(counter));
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
