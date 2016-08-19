package com.ibm.mom.concurrency;

import java.util.concurrent.Exchanger;

/**
 * Exchanger�������߳̿��Ի�����Ϣ�� �����з������߳����յı����ﵹˮ���˿��̴߳�װ��ˮ�ı������ˮ��
 * Ȼ��ͨ��Exchanger˫���������ӣ��������������ձ����ﵹˮ���˿ͽ��ź�ˮ�� Ȼ�󽻻�������ܶ���ʼ��
 */
public class ExchangerTest {
	public static void main(String[] args) {
		ExchangerTest.testExchanger();
	}

	// ����һ��װˮ�ı���
	public static class Cup {
		// ��ʶ�����Ƿ���ˮ
		private boolean full = false;

		public Cup(boolean full) {
			this.full = full;
		}

		// ��������ˮ��������Ҫ2s
		public void addWater() {
			if (!this.full) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.full = true;
			}
		}

		// �˿ͺ�ˮ��������Ҫ5s
		public void drinkWater() {
			if (this.full) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.full = false;
			}
		}
	}

	public static void testExchanger() {
		// ��ʼ��һ��Exchanger�����涨�ɽ�������Ϣ�����Ǳ���
		final Exchanger<Cup> exchanger = new Exchanger<Cup>();
		// ��ʼ��һ���յı��Ӻ�װ��ˮ�ı���
		final Cup initialEmptyCup = new Cup(false);
		final Cup initialFullCup = new Cup(true);

		// �������߳�
		class Waiter implements Runnable {
			public void run() {
				Cup currentCup = initialEmptyCup;
				try {
					int i = 0;
					while (i < 2) {
						// ���յı������ˮ
						System.out.println("��������ʼ����������ˮ��" + System.nanoTime());
						currentCup.addWater();
						System.out.println("��������ˮ��ϣ�" + System.nanoTime());
						
						// ��������͹˿͵Ŀձ��ӽ���
						System.out.println("�������ȴ���˿ͽ������ӣ�" + System.nanoTime());
						currentCup = exchanger.exchange(currentCup);
						System.out.println("��������˿ͽ���������ϣ�" + System.nanoTime());
						i++;
					}
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}

		// �˿��߳�
		class Customer implements Runnable {
			public void run() {
				Cup currentCup = initialFullCup;
				try {
					int i = 0;
					while (i < 2) {
						// �ѱ������ˮ�ȵ�
						System.out.println("�˿Ϳ�ʼ��ˮ��" + System.nanoTime());
						currentCup.drinkWater();
						System.out.println("�˿ͺ�ˮ��ϣ�" + System.nanoTime());
						
						// ���ձ��Ӻͷ������������ӽ���
						System.out.println("�˿͵ȴ���������������ӣ�" + System.nanoTime());
						currentCup = exchanger.exchange(currentCup);
						System.out.println("�˿������������������ϣ�" + System.nanoTime());
						i++;
					}
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}

		new Thread(new Waiter()).start();
		new Thread(new Customer()).start();
	}

}
