package com.ibm.mom.concurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * The rules by which a thread is allowed to lock the ReadWriteLock either for reading or writing 
 * the guarded resource, are as follows: 
 * 
 * Read Lock -     
 * If no threads have locked the ReadWriteLock for writing, and no thread have requested
 * a write lock (but not yet obtained it).  Thus, multiple threads can lock the lock for reading.
 * 
 * Write Lock -    
 * If no threads are reading or writing. Thus, only one thread at a time can lock the lock for writing.  
 */
public class ReadWriteLockExample {
	public static void main(String[] args) {
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

		readWriteLock.readLock().lock();

		// multiple readers can enter this section
		// if not locked for writing, and not writers waiting
		// to lock for writing.

		readWriteLock.readLock().unlock();


		readWriteLock.writeLock().lock();

		// only one writer can enter this section,
		// and only if no threads are currently reading.

		readWriteLock.writeLock().unlock();
	}
}
