package com.ibm.mom.concurrency;

public class ThreadDemo01 {
	public static void main(String[] args) {
		MyThread my = new MyThread();
		Thread t1 = new Thread(my, "t1");
		Thread t2 = new Thread(my, "t2");
		t1.start();
		t2.start();
	}
}


/**
 * ����ʵ��Runnable�ӿڷ�ʽ��
 * ��1���ŵ㣺�߳���ֻ��ʵ����Runable�ӿڣ������Լ̳��������ࡣ�����ַ�ʽ�£����Զ���̹߳���ͬһ��Ŀ�����
 * 			���Էǳ��ʺ϶����ͬ�߳�������ͬһ����Դ��������Ӷ����Խ�CPU��������ݷֿ����γ�������ģ�ͣ��Ϻõ���������������˼�롣
 * ��2��ȱ�㣺�����΢���ӣ������Ҫ���ʵ�ǰ�̣߳�����ʹ��Thread.currentThread()������
 */
class MyThread implements Runnable {
	private int countDown = 20;

	@Override
	public void run() {
		while (this.countDown-- > 0) {
			System.out.println(Thread.currentThread().getName() + "---" + this.countDown);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
