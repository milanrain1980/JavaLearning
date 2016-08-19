package com.ibm.mom.concurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapComparison implements Runnable {
	private static Map<Integer, String> map;
	private Random random = new Random(System.currentTimeMillis());

	public static void main(String[] args) throws InterruptedException {
		runPerformanceTest(new Hashtable<Integer, String>());
		runPerformanceTest(Collections.synchronizedMap(new HashMap<Integer, String>()));
		runPerformanceTest(new ConcurrentHashMap<Integer, String>());
		runPerformanceTest(new ConcurrentSkipListMap<Integer, String>());
	}

	private static void runPerformanceTest(Map<Integer, String> map) throws InterruptedException {
		MapComparison.map = map;
		fillMap(map);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		long startMillis = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
			executorService.execute(new MapComparison());
		}
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
		System.out.println(
				map.getClass().getSimpleName() + " took " + (System.currentTimeMillis() - startMillis) + " ms");
	}

	private static void fillMap(Map<Integer, String> map) {
		for (int i = 0; i < 100; i++) {
			map.put(i, String.valueOf(i));
		}
	}

	public void run() {
		for (int i = 0; i < 100000; i++) {
			int randomInt = random.nextInt(100);
			map.get(randomInt);
			randomInt = random.nextInt(100);
			map.put(randomInt, String.valueOf(randomInt));
		}
	}
	
}
