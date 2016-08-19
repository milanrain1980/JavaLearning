package com.ibm.mom.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

	public static void main(String[] args) {
		final int SIZE = 100000;
		double[] numbers = new double[SIZE];
		for (int i = 0; i < SIZE; i++) {
			numbers[i] = Math.random();
		}
		CounterNew counter = new CounterNew(numbers, 0, numbers.length,
				new Filter() {
					@Override
					public boolean accept(double x) {
						return x > 0.5;
					}
				});

		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(counter);
		System.out.println(counter.join());
	}
}

interface Filter {
	boolean accept(double x);
}

class CounterNew extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;

	public static final int THRESHOLD = 1000;
	private double[] values;
	private int from;
	private int to;
	private Filter filter;

	public CounterNew(double[] values, int from, int to, Filter filter) {
		this.values = values;
		this.from = from;
		this.to = to;
		this.filter = filter;
	}

	@Override
	protected Integer compute() {
		if (to - from < THRESHOLD) {
			int count = 0;
			for (int i = from; i < to; i++) {
				if (filter.accept(values[i])) {
					count++;
				}
			}

			return count;
		} else {
			int mid = (from + to) / 2;
			CounterNew first = new CounterNew(values, from, mid, filter);
			CounterNew second = new CounterNew(values, mid, to, filter);
			invokeAll(first, second);

			return first.join() + second.join();
		}
	}

}