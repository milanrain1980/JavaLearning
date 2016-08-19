package com.ibm.mom.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Main Differences Between Locks and Synchronized Blocks:
 *
 * 1) A synchronized block makes no guarantees about the sequence 
 * in which threads waiting to entering it are granted access.
 * 
 * 2) You cannot pass any parameters to the entry of a synchronized block. 
 * Thus, having a timeout trying to get access to a synchronized block is not possible.
 * 
 * 3) The synchronized block must be fully contained within a single method. 
 * A Lock can have its calls to lock() and unlock() in separate methods.
 *  
 */
public class LockExample {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		lock.lock();

		//critical section

		lock.unlock();
	}
}
