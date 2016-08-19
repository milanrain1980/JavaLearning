package com.ibm.mom.concurrency;

public class SequenceNumber {
	// ��ͨ�������ڲ��า��ThreadLocal��initialValue()������ָ����ʼֵ
	private ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	// �ڻ�ȡ��һ������ֵ
	public Integer getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}

	public static void main(String[] args) {
		SequenceNumber sn = new SequenceNumber();
		// �� 3���̹߳���sn�����Բ������к�
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
	}
}

class TestClient implements Runnable {
	private SequenceNumber sn;

	public TestClient(SequenceNumber sn) {
		this.sn = sn;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("thread[" + Thread.currentThread().getName()
					+ "] sn [" + sn.getNextNum() + "]");
		}
	}
}
