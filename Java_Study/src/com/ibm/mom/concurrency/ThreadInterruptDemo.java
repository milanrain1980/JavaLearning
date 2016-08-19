package com.ibm.mom.concurrency;

/**
 * �ж��߳�
 * 
 *1. interrupt��������ֻ���������жϱ�־����û�������ж��߳�ִ��
 *2. �Զ���������ж��߳�
 *
 */
public class ThreadInterruptDemo {

	public static void main(String[] args) {
		MyThread4 my = new MyThread4();
		MyThread5 my2 = new MyThread5();
		
		Thread t1 = new Thread(my, "t1");
		Thread t2 = new Thread(my2, "t2");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("main-" + i);
			if (i == 5) {
				t1.interrupt();		// �ж��̣߳�����һ���жϱ�ǣ��ж�״̬Ϊtrue��
				my2.setFlag(false);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class MyThread5 implements Runnable {
	private boolean flag = true;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		int i =0;
		while (flag) {
			i++;
			System.out.println(Thread.currentThread().getName()+"-" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class MyThread4 implements Runnable {
	@Override
	public void run() {
		int i =0;
		while (!Thread.interrupted()) {
			System.out.println(Thread.currentThread().getName() + "-" + i);
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}

}
