package com.ibm.mom.date;

public class Timer {
	private long startTime = 0;
	private long endTime = 0;

	public void start() {
		this.startTime = System.currentTimeMillis();
	}

	public void end() {
		this.endTime = System.currentTimeMillis();
	}

	public long getStartTime() {
		return this.startTime;
	}

	public long getEndTime() {
		return this.endTime;
	}

	public long getTotalTime() {
		return this.endTime - this.startTime;
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.start();
		// do something....
		timer.end();
		long totalTime = timer.getTotalTime();
		System.out.println(totalTime);
	}
}
