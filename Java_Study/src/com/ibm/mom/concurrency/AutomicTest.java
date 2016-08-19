package com.ibm.mom.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * �й�ԭ�������÷��ܼ򵥣��ؼ��Ƕ�ԭ��������ʶ��
 * ԭ�ӽ����Ǳ�֤����������ԭ���ԣ�������������Ҫ�����̰߳�ȫ�ġ�
 * 
 * @author ligang13
 */
public class AutomicTest {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Lock lock = new ReentrantLock(false);
		
		Runnable t1 = new MyRunnable("����", 2000, lock);
		Runnable t2 = new MyRunnable("����", 3600, lock);
		Runnable t3 = new MyRunnable("����", 2700, lock);
		Runnable t4 = new MyRunnable("����", 600, lock);
		Runnable t5 = new MyRunnable("��ţ", 1300, lock);
		Runnable t6 = new MyRunnable("����", 800, lock);
		
		// ִ�и����߳�
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		
		// �ر��̳߳�
		pool.shutdown();
	}

}

class MyRunnable implements Runnable {
	private static AtomicLong aLong = new AtomicLong(10000); // ԭ������ÿ���̶߳��������ɲ���
	private String name; // ������
	private int x; // ��������
	private Lock lock;

	MyRunnable(String name, int x, Lock lock) {
		this.name = name;
		this.x = x;
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.lock();
		System.out.println(name + "ִ����" + x + "����ǰ��" + aLong.addAndGet(x));
		lock.unlock();
	}
}
