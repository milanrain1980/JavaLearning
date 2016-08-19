package com.ibm.mom.concurrency;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference is different from the AtomicReference in that the
 * AtomicStampedReference keeps both an object reference and a stamp internally.
 * The reference and stamp can be swapped using a single atomic compare-and-swap
 * operation, via the compareAndSet() method.
 * 
 * The AtomicStampedReference is designed to be able to solve the A-B-A problem
 * which is not possible to solve with an AtomicReference alone.
 */
public class AtomicStampedReferenceExample {
	public static void main(String[] args) {
		String initialRef = "text";
		int initialStamp = 0;

		AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<String>(initialRef, initialStamp);

		int[] stampHolder = new int[1];
		Object ref = atomicStampedReference.get(stampHolder);

		System.out.println("ref = " + ref);
		System.out.println("stamp = " + stampHolder[0]);
		System.out.println("========================================");
		
		compareAndSet();
	}

	
	static void compareAndSet() {
		String initialRef   = "initial value referenced";
		int    initialStamp = 0;

		AtomicStampedReference<String> atomicStringReference =
		    new AtomicStampedReference<String>(
		        initialRef, initialStamp
		    );

		String newRef   = "new value referenced";
		int    newStamp = initialStamp + 1;

		boolean exchanged = atomicStringReference
		    .compareAndSet(initialRef, newRef, initialStamp, newStamp);
		System.out.println("exchanged: " + exchanged);  //true

		exchanged = atomicStringReference
		    .compareAndSet(initialRef, "new string", newStamp, newStamp + 1);
		System.out.println("exchanged: " + exchanged);  //false

		exchanged = atomicStringReference
		    .compareAndSet(newRef, "new string", initialStamp, newStamp + 1);
		System.out.println("exchanged: " + exchanged);  //false

		exchanged = atomicStringReference
		    .compareAndSet(newRef, "new string", newStamp, newStamp + 1);
		System.out.println("exchanged: " + exchanged);  //true
	}
	
	/**
	 * The AtomicStampedReference is designed to solve the A-B-A problem. 
	 * The A-B-A problem is when a reference is changed from pointing to A, then to B and then back to A.
	 * 
	 *  When using compare-and-swap operations to change a reference atomically, and making sure that 
	 *  only one thread can change the reference from an old reference to a new, detecting the A-B-A situation is impossible.
	 *  
	 *   The A-B-A problem can occur in non-blocking algorithms. Non-blocking algorithms often use a reference to 
	 *   an ongoing modification to the guarded data structure, to signal to other threads 
	 *   that a modification is currently ongoing. If thread 1 sees that there is no ongoing modification (reference points to null),
	 *   another thread may submit a modification (reference is now non-null), complete the modification and 
	 *   swap the reference back to null without thread 1 detecting it. 
	 *   
	 *   By using an AtomicStampedReference instead of an AtomicReference it is possible to detect the A-B-A situation. 
	 *   Thread 1 can copy the reference and stamp out of the AtomicStampedReference atomically using get(). 
	 *   If another thread changes the reference from A to B and then back to A, then the stamp will 
	 *   have changed (provided threads update the stamp sensibly - e.g increment it). 
	 */
	static void ABAProblem() {
		String initialRef = "text";
		int initialStamp = 0;

		AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<String>(initialRef, initialStamp);

		int[] stampHolder = new int[1];
		Object ref = atomicStampedReference.get(stampHolder);

		if(ref == null){
		    //prepare optimistic modification
		}

		//if another thread changes the reference and stamp here,
		//it can be detected

		int[] stampHolder2 = new int[1];
		Object ref2 = atomicStampedReference.get(stampHolder);

		if(ref == ref2 && stampHolder[0] == stampHolder2[0]){
		    //no modification since optimistic modification was prepared

		} else {
		    //retry from scratch.
		}
	}
	
}
