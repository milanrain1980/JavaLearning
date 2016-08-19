package com.ibm.mom.concurrency;

import java.lang.Thread.State;

/**
 * a thread also has a state, which can be one of the following:
 * 
 *     1.NEW: A thread that has not yet started is in this state.
 *     2.RUNNABLE: A thread executing in the Java virtual machine is in this state.
 *     3.BLOCKED: A thread that is blocked waiting for a monitor lock is in this state.
 *     4.WAITING: A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
 *     5.TIMED_WAITING: A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
 *     6.TERMINATED: A thread that has exited is in this state.
 */
public class MainThread {

	public static void main(String[] args) {
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		State state = Thread.currentThread().getState();
		String threadGroupName = Thread.currentThread().getThreadGroup().getName();
		
		System.out.println("id=" + id + "; name=" + name + "; priority=" + priority + "; state=" + state
				+ "; threadGroupName=" + threadGroupName);
	}
}
