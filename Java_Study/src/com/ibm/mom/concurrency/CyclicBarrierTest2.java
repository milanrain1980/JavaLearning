package com.ibm.mom.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch��CyclicBarrier���÷��ϵĲ�ͬ:
 * CountDownLatch ������һ���̺߳���һ�����߳�֮��Ĺ���Э������Ҫ����һ�����̵߳ȴ�һ�鹤���̵߳�������Ϻ��ټ���ִ�У�
 * CyclicBarrier ������һ������̣߳�����һ���߳���Ҫ��һ��ʱ����ϴ��һ�£�����ͬʱ��ʼһ��������
 * ���⣬CyclicBarrier ��ѭ�����Ժ͹��캯�������ܵ� Runnable ����Ҳ�� CountDownLatch �����߱��ġ�
 */
public class CyclicBarrierTest2 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		final int parties = 3;
		final CyclicBarrier cb = new CyclicBarrier(parties); 			// �����߳�ͬʱ����
		for (int i = 0; i < parties; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println("�߳�"
								+ Thread.currentThread().getName()
								+ "�������Ｏ�ϵص㣬��ǰ����" + (cb.getNumberWaiting()) + "���ѵ���,"
								+ (cb.getNumberWaiting() == (parties - 1) ?  "�������ˣ������߰�" : "���ڵȺ�"));
						try {
							cb.await();
							System.out.println("Need to do somethings...");
						} catch (BrokenBarrierException e) {
							e.printStackTrace();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			pool.execute(runnable);
		}
		pool.shutdown();
	}
}