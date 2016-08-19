package com.ibm.mom.concurrency;

/**
 * sleep()�Ǿ�̬��������������ģ��������õ�ǰ�߳�����;
 * join()��ʹ�߳�ͬ��������ĳ���߳������t.join()��ʾ"t�߳�"ִ������ִ�е�ǰ�߳�;
 * interrupt()���߳��趨һ����־��ʾ���߳��ѱ��жϣ������쳣����ʱ�����������־ ������catch�Ӿ��У��ñ�־Ϊfalse;
 */
public class SleepJoinDemo {
	public static void main(String[] args) {
		Sleeper sleep1 = new Sleeper("sleep1", 1000);
		Sleeper sleep2 = new Sleeper("sleep2", 1000);
		
		new Joiner("join1", sleep1);
		new Joiner("join2", sleep1);
		
		sleep2.interrupt();
	}
}

class Sleeper extends Thread {
	// ���Դ����趨˯��ʱ��
	private int sleepTime;

	public Sleeper(String name, int sleepTime) {
		super(name);
		this.sleepTime = sleepTime;
		start();// �ڹ��췽��������
	}

	@Override
	public void run() {
		try {
			sleep(sleepTime);
		} catch (InterruptedException e) {
			System.out.println(getName() + " was interrupted, and "
					+ "isInterrupted():" + isInterrupted());
			return;
		}
		System.out.println(getName() + " has awakened");
	}
}

class Joiner extends Thread {
	private Sleeper sleeper;

	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}

	@Override
	public void run() {
		try {
			sleeper.join();		// �ϲ����첽��ͬ��: �ȴ�sleeper�߳�ִ�н������ټ�������ִ�У�
		} catch (InterruptedException e) {
			System.out.println("interrupted");
		}
		System.out.println(getName() + " join completed");
	}
}