package com.ibm.mom.timertask;

import java.util.Timer;

public class TestTask {

	public static void main(String[] args) {
		Timer timer = new Timer();
		MyTask task = new MyTask();
		timer.schedule(task, 5000, 2000);
	}

}
