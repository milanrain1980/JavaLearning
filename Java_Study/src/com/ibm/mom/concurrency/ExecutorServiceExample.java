package com.ibm.mom.concurrency;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

	public static void main(String[] args) throws Exception {
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();
		ExecutorService executorService2 = Executors.newFixedThreadPool(10);
		ExecutorService executorService3 = Executors.newScheduledThreadPool(10);

		executeRunnable();

		submitRunnable();

		submitCallable();
		
		invokeAny();
		
		invokeAll();
	}

	static void executeRunnable() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.execute(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task");
			}
		});

		executorService.shutdown();
	}

	static void submitRunnable() throws Exception {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task");
			}
		});

		future.get(); // returns null if the task has finished correctly.

		executorService.shutdown();
	}

	static void submitCallable() throws Exception {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new Callable() {
			public Object call() throws Exception {
				System.out.println("Asynchronous Callable");
				return "Callable Result";
			}
		});

		System.out.println("future.get() = " + future.get());

		executorService.shutdown();
	}

	static void invokeAny() throws Exception {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 1";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 2";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 3";
			}
		});

		String result = executorService.invokeAny(callables);

		System.out.println("result = " + result);

		executorService.shutdown();
	}

	static void invokeAll() throws Exception {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 3";
		    }
		});

		List<Future<String>> futures = executorService.invokeAll(callables);

		for(Future<String> future : futures){
		    System.out.println("future.get = " + future.get());
		}

		executorService.shutdown();
	}
	
}
