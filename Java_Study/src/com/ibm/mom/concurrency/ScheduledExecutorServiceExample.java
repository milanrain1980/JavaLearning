package com.ibm.mom.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

	public static void main(String[] args) throws Exception {
		scheduleCallable();
		
//		scheduleAtFixedRate();
		
		scheduleWithFixedRate();
	}

	static void scheduleCallable() throws Exception {
		ScheduledExecutorService scheduledExecutorService = Executors
				.newScheduledThreadPool(5);

		ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(
				new Callable() {
					public Object call() throws Exception {
						System.out.println("scheduleCallable Executed!");
						return "Called!";
					}
				}, 3, TimeUnit.SECONDS);

		scheduledExecutorService.shutdown();
	}

	/**
	 * In the scheduleAtFixedRate() method the "period" is interpreted as a delay between the "start" 
	 * of the previous execution, until the start of the next execution. 
	 */
	static void scheduleAtFixedRate() throws Exception {
		ScheduledExecutorService scheduledExecutorService = Executors
				.newScheduledThreadPool(5);

		ScheduledFuture scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(
				new Runnable() {
					@Override
					public void run() {
						System.out.println("scheduleAtFixedRate Executed!");
					}
				}, 1, 3, TimeUnit.SECONDS);
		
		scheduledFuture.get();

		scheduledExecutorService.shutdown();
	}
	
	/**
	 * In this scheduleWithFixedRate() method, the "period" is interpreted as the delay between the "end" 
	 * of the previous execution, until the start of the next. 
	 * The delay is thus between finished executions, not between the beginning of executions. 
	 */
	static void scheduleWithFixedRate() throws Exception {
		ScheduledExecutorService scheduledExecutorService = Executors
				.newScheduledThreadPool(5);

		ScheduledFuture scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(
				new Runnable() {
					@Override
					public void run() {
						System.out.println("scheduleWithFixedDelay Executed!");
					}
				}, 1, 3, TimeUnit.SECONDS);

		scheduledFuture.get();
		
		scheduledExecutorService.shutdown();
	}
}
