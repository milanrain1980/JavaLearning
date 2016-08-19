package com.ibm.mom.concurrency;

/**
 * volatile��ʾԭ���ԣ��ɼ��ԡ�
 * 
 *  ���ڶ���߳�֮�乲��ı�����ÿ���̶߳����Լ���һ�ݿ��������߳�1�ı����ֵʱ�������̲߳�������֪���ñ���ֵ�ı��ˣ�
 *  volatile�ͱ�֤�˱���ֵ�Ը����߳̿ɼ���һ���̸߳ı��ֵ�����������߳��и�ֵҲ�ı䡣
 *  ԭ���Ա������������жϣ������������ֵ��
 *  
 */
public class VolatileDemo implements Runnable {
	private volatile int i = 0;		// volatile���ÿɼ���

	public synchronized int getValue() {
		return i;
	}

	private synchronized void enenIncrement() {
		i++;
		i++;
	}

	@Override
	public void run() {
		while (true)
			enenIncrement();
	}

	public static void main(String[] args) {
		VolatileDemo vd = new VolatileDemo();
		new Thread(vd).start();
		new Thread(vd).start();
		while (true) {
			int val = vd.getValue();
			if (val % 2 != 0) {		// �����������˳�����
				System.out.println(val + " is not enen!");
				System.exit(0);
			}
			System.out.println(val);
		}

	}
}