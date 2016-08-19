package com.ibm.mom.concurrency;

import java.util.LinkedList;
import java.util.List;

public class ThreadPoolDemo {
	public static void main(String[] args) {
		// ����3���̵߳��̳߳�
		ThreadPool tp = ThreadPool.getThreadPool(3);
		tp.execute(new Runnable[] { new Task(), new Task(), new Task() });
		tp.execute(new Runnable[] { new Task(), new Task(), new Task() });
		System.out.println(tp);
		tp.destroy();// �����̶߳�ִ����ɲ�destory
		System.out.println(tp);
	}

	// ������
	static class Task implements Runnable {
		private static volatile int i = 1;

		@Override
		public void run() {// ִ������
			System.out.println("���� " + (i++) + " ���");
		}
	}
}

final class ThreadPool {
	// �̳߳���Ĭ���̵߳ĸ���Ϊ5
	private static int worker_num = 5;
	// �����߳�
	private WorkThread[] workThrads;
	// δ���������
	private static volatile int finished_task = 0;
	// ������У���Ϊһ������,List�̲߳���ȫ
	private List<Runnable> taskQueue = new LinkedList<Runnable>();
	private static ThreadPool threadPool;

	// ��������Ĭ���̸߳������̳߳�
	private ThreadPool() {
		this(5);
	}

	// �����̳߳�,worker_numΪ�̳߳��й����̵߳ĸ���
	private ThreadPool(int worker_num) {
		ThreadPool.worker_num = worker_num;
		workThrads = new WorkThread[worker_num];
		for (int i = 0; i < worker_num; i++) {
			workThrads[i] = new WorkThread();
			workThrads[i].start();// �����̳߳��е��߳�
		}
	}

	// ��̬ģʽ�����һ��Ĭ���̸߳������̳߳�
	public static ThreadPool getThreadPool() {
		return getThreadPool(ThreadPool.worker_num);
	}

	// ��̬ģʽ�����һ��ָ���̸߳������̳߳�,worker_num(>0)Ϊ�̳߳��й����̵߳ĸ���
	// worker_num<=0����Ĭ�ϵĹ����̸߳���
	public static ThreadPool getThreadPool(int worker_num1) {
		if (worker_num1 <= 0)
			worker_num1 = ThreadPool.worker_num;
		if (threadPool == null)
			threadPool = new ThreadPool(worker_num1);
		return threadPool;
	}

	// ִ������,��ʵֻ�ǰ��������������У�ʲôʱ��ִ�����̳߳ع���������
	public void execute(Runnable task) {
		synchronized (taskQueue) {
			taskQueue.add(task);
			taskQueue.notify();
		}
	}

	// ����ִ������,��ʵֻ�ǰ��������������У�ʲôʱ��ִ�����̳߳ع���������
	public void execute(Runnable[] tasks) {
		synchronized (taskQueue) {
			for (Runnable t : tasks) {
				taskQueue.add(t);
			}
			taskQueue.notify();
		}
	}

	// ����ִ������,��ʵֻ�ǰ��������������У�ʲôʱ��ִ�����̳߳ع���������
	public void execute(List<Runnable> tasks) {
		synchronized (taskQueue) {
			for (Runnable t : tasks) {
				taskQueue.add(t);
			}
			taskQueue.notify();
		}
	}

	// �����̳߳�,�÷�����֤������������ɵ�����²����������̣߳�����ȴ�������ɲ�����
	public void destroy() {
		while (!taskQueue.isEmpty()) {// �����������ûִ����ɣ�����˯���
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// �����߳�ֹͣ����������Ϊnull
		for (int i = 0; i < worker_num; i++) {
			workThrads[i].stopWorker();
			workThrads[i] = null;
		}
		threadPool = null;
		taskQueue.clear();// ����������
	}

	// ���ع����̵߳ĸ���
	public int getWorkThreadNumber() {
		return worker_num;
	}

	// �������������ĸ���,������������ֻ����������е�������������ܸ�����û��ʵ��ִ�����
	public int getFinishedTasknumber() {
		return finished_task;
	}

	// ����������еĳ��ȣ�����û������������
	public int getWaitTasknumber() {
		return taskQueue.size();
	}

	// ����toString�����������̳߳���Ϣ�������̸߳�����������������
	@Override
	public String toString() {
		return "WorkThread number:" + worker_num + "  finished task number:"
				+ finished_task + "  wait task number:" + getWaitTasknumber();
	}

	/**
	 * �ڲ��࣬�����߳�
	 */
	private class WorkThread extends Thread {
		// �ù����߳��Ƿ���Ч�����ڽ����ù����߳�
		private boolean isRunning = true;

		/*
		 * �ؼ����ڰ������������в��գ���ȡ������ִ�У���������пգ���ȴ�
		 */
		@Override
		public void run() {
			Runnable r = null;
			while (isRunning) {// ע�⣬���߳���Ч����Ȼ����run���������߳̾�û����
				synchronized (taskQueue) {
					while (isRunning && taskQueue.isEmpty()) {// ����Ϊ��
						try {
							taskQueue.wait(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (!taskQueue.isEmpty())
						r = taskQueue.remove(0);// ȡ������
				}
				if (r != null) {
					r.run();// ִ������
				}
				finished_task++;
				r = null;
			}
		}

		// ֹͣ�������ø��߳���Ȼִ����run��������Ȼ����
		public void stopWorker() {
			isRunning = false;
		}
	}
}