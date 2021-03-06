package com.ibm.mom.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Java5中，添加了障碍器类，为了适应一种新的设计需求，比如一个大型的任务，
 * 常常需要分配好多子任务去执行，只有当所有子任务都执行完成时候，才能执行主任务，这时候，就可以选择障碍器了,
 * 它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point).
 * 
 * @author ligang13
 */
public class BarrierTest {

	public static void main(String[] args) {
		// 创建障碍器，并设置MainTask为所有定数量的线程都达到障碍点时候所要执行的任务(Runnable)
		CyclicBarrier cb = new CyclicBarrier(7, new MainTask());
		new SubTask("A", cb).start();
		new SubTask("B", cb).start();
		new SubTask("C", cb).start();
		new SubTask("D", cb).start();
		new SubTask("E", cb).start();
		new SubTask("F", cb).start();
		new SubTask("G", cb).start();
	}
}

/**
 * 主任务
 */
class MainTask implements Runnable {
	public void run() {
		System.out.println(">>>>主任务执行了！<<<<");
	}
}

/**
 * 子任务
 */
class SubTask extends Thread {
	private String name;
	private CyclicBarrier cb;

	SubTask(String name, CyclicBarrier cb) {
		this.name = name;
		this.cb = cb;
	}

	public void run() {
		System.out.println("[子任务" + name + "]开始执行了！");
		for (int i = 0; i < 999999; i++); 	// 模拟耗时的任务
		System.out.println("[子任务" + name + "]开始执行完成了，并通知障碍器已经完成！");
		try {
			// 通知障碍器已经完成
			cb.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}