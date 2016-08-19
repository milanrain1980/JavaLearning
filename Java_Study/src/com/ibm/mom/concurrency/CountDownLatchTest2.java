package com.ibm.mom.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch��CyclicBarrier���÷��ϵĲ�ͬ:
 * CountDownLatch ������һ���̺߳���һ�����߳�֮��Ĺ���Э������Ҫ����һ�����̵߳ȴ�һ�鹤���̵߳�������Ϻ��ټ���ִ�У�
 * CyclicBarrier ������һ������̣߳�����һ���߳���Ҫ��һ��ʱ����ϴ��һ�£�����ͬʱ��ʼһ��������
 * ���⣬CyclicBarrier ��ѭ�����Ժ͹��캯�������ܵ� Runnable ����Ҳ�� CountDownLatch �����߱��ġ�
 */

/**
 * NȡֵΪ100,000,000�����̵߳���Ϊ100��ÿ���߳�ִ��1,000,000��ģ��ʵ��
 */
public class CountDownLatchTest2 {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		int threadSize = 100;
		int N = 1000000;
		Object semaphore = new Object();
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(threadSize);
		int sleepTime = 2000;

		// �����ض����̳߳أ���СΪthreadSizde
		System.out.println("begins!");
		ExecutorService exe = Executors.newFixedThreadPool(threadSize);

		for (int i = 0; i < threadSize; i++) {
			exe.execute(new ProModel(i + 1, startSignal, doneSignal, N, semaphore));
		}
		
		try {
			Thread.sleep(sleepTime);				// �ȴ������̴߳����ɹ�
			
			startSignal.countDown();		// �ȴ�end״̬��Ϊ0.�ͷ����еȴ��߳�
			
			doneSignal.await(); 				// �ȴ�end״̬��Ϊ0��
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("ends!");
			System.out.println(4 * (float) ProModel.getTotal() / (float) (threadSize * N));			// Calculate the final result
		}

		exe.shutdown();

		long end = System.currentTimeMillis();
		System.out.println("used time(ms):" + (end - begin - sleepTime));
	}
}

class ProModel implements Runnable {
	private int N; 								// ���ʵ����ܴ���
	public static int M = 0; 			// ���������Բ�еĴ���

	@SuppressWarnings("unused")
	private int id;
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;
	private Object semaphore;

	public ProModel(int id, CountDownLatch startSignal, CountDownLatch doneSignal, int N, Object semaphore) {
		this.id = id;
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
		this.N = N;
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			startSignal.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int tempM = 0;
		for (int i = 0; i < N; i++) {
			if (isInCircle()) {
				tempM++;
			}
		}

		synchronized (semaphore) {
			add(tempM);
		}

		doneSignal.countDown();						// ʹend״̬��1
	}

	public void add(int tempM) {
		System.out.println(Thread.currentThread().getName());
		M = M + tempM;
		System.out.println(M);
	}

	// �������һ��������������ĵ㣬�ж����Ƿ���Բ��
	public boolean isInCircle() {
		double x = Math.random();
		double y = Math.random();
		if ((x - 0.5) * (x - 0.5) + (y - 0.5) * (y - 0.5) < 0.25)
			return true;
		else
			return false;
	}

	public static int getTotal() {
		return M;
	}
}
