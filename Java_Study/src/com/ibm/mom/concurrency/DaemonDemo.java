package com.ibm.mom.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * ��ν�ĺ�̨�̣߳���ָ�ڳ������е�ʱ���ں�̨�ṩһ��ͨ�÷�����̣߳����������̲߳������ڳ����в��ɻ�ȱ�Ĳ��֡�
 * ��˵����еķǺ�̨�߳̽���ʱ������Ҳ����ֹ�ˣ�ͬʱ��ɱ�����к�̨�̡߳�������˵��ֻҪ���κηǺ�̨�߳�(�û��߳�)�������У�
 * ����Ͳ�����ֹ����̨�߳��ڲ�ִ��finally�Ӿ������¾ͻ���ֹ��run��������̨�̴߳��������߳�Ҳ�Ǻ�̨�̡߳�
 *
 */
public class DaemonDemo implements Runnable {
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				System.out.println("#" + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {// ��̨�̲߳�ִ��finally�Ӿ�
			System.out.println("finally ");
		}
	}

	/**
	 * �������ӽ�����Կ�����ʮ�����̲߳�û������ѭ���Ĵ�ӡ�����������߳�(main())�˳���JVMǿ�ƹر����к�̨�̡߳�
	 * ���������κ�ϣ�����ֵ�ȷ����ʽ����finally�Ӿ䲻ִ�С�
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread daemon = new Thread(new DaemonDemo());
			// ������start֮ǰ����Ϊ��̨�߳�
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("All daemons started");
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}