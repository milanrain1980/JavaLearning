package com.ibm.mom.concurrency;

public class ThreadDemo02 {

	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2();
		MyThread2 t2 = new MyThread2();
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

}

/**
 * ���ü̳�Thread�෽ʽ��
 * ��1���ŵ㣺��д�򵥣������Ҫ���ʵ�ǰ�̣߳�����ʹ��Thread.currentThread()������ֱ��ʹ��this�����ɻ�õ�ǰ�̡߳�
 * ��2��ȱ�㣺��Ϊ�߳����Ѿ��̳���Thread�࣬���Բ����ټ̳������ĸ��ࡣ
 */
class MyThread2 extends Thread {
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
