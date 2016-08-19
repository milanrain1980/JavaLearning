package com.ibm.mom.concurrency;

import java.util.logging.Logger;

public class ThreadTest1 {
	private static Logger logger = Logger.getLogger("ThreadTest1");

	// �߳�1
	static class T1 implements Runnable {
		ThreadTest1 s;

		public T1(ThreadTest1 sameObj) {
			this.s = sameObj;
		}

		// �߳�1����ͬ������
		public void run() {
			logger.info("�����߳�1...........");
			s.syn();
			logger.info("�˳��߳�1...........");
		}
	}

	// �߳�2
	static class T2 implements Runnable {
		ThreadTest1 s;

		public T2(ThreadTest1 sameObj) {
			this.s = sameObj;
		}

		// �߳�2���ʷ�ͬ������
		public void run() {
			logger.info("�����߳�2...........");
			s.nonSyn();
			logger.info("�˳��߳�2...........");
		}
	}

	// �����ͬ������
	public synchronized void syn() {
		logger.info("�������������߳�1��ʼ����ͬ������");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("�������������߳�1�˳�ͬ������");
	}

	// ����ķ�ͬ������
	public void nonSyn() {
		logger.info("��������߳�2��ʼ���ʷ�ͬ������");
		for (int i = 0; i < 5; i++) {
			try {
				logger.info("�߳�2���ڷ��ʷ�ͬ������!!!");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.info("��������߳�2�˳���ͬ������");
	}

	public static void main(String[] args) {
		// ���Ƕ��߳�Ҫ���ʵ�ͬһ������
		ThreadTest1 sameObj = new ThreadTest1();

		// �߳�1����ͬ������, �߳�2���ʷ�ͬ������.
		Thread t1 = new Thread(new T1(sameObj));
		Thread t2 = new Thread(new T2(sameObj));

		t1.start();
		t2.start();
	}
}