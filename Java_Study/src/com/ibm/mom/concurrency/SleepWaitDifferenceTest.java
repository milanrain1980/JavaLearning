package com.ibm.mom.concurrency;

/**
 * Java中的sleep()和wait()的区别
 * 
 * sleep是Thread类的静态方法, sleep的作用是让线程休眠制定的时间，在时间到达时恢复，也就是说sleep将在接到时间到达事件事恢复线程执行.
 * wait是Object的方法,也就是说可以对任意一个对象调用wait方法，调用wait方法将会将"调用者的线程"挂起，
 * 直到其他线程调用同一个对象的notify方法才会重新激活调用者.
 */
public class SleepWaitDifferenceTest {

	public static void main(String[] args) {
		// Start thread1...
		new Thread(new Thread1()).start();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Start thread2...
		new Thread(new Thread2()).start();
	}

	private static class Thread1 implements Runnable {
		@Override
		public void run() {
			synchronized (SleepWaitDifferenceTest.class) {
				System.out.println("enter thread1...");
				System.out.println("thread1 is waiting...");
				try {
					// 调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
					SleepWaitDifferenceTest.class.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("thread1 is going on ....");
				System.out.println("thread1 is over!!!");
			}
		}
	}

	private static class Thread2 implements Runnable {
		@Override
		public void run() {
			synchronized (SleepWaitDifferenceTest.class) {
				System.out.println("enter thread2....");

				// 只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
				SleepWaitDifferenceTest.class.notify();
				
				// ==================
				// 区别:
				// 如果我们把代码：TestD.class.notify();给注释掉，即TestD.class调用了wait()方法，但是没有调用notify()
				// 方法，则线程永远处于挂起状态。
				System.out.println("thread2 is sleeping....");
				try {
					// sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
					// 但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
					// 在调用sleep()方法的过程中，线程不会释放对象锁。
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("thread2 is going on....");
				System.out.println("thread2 is over!!!");
			}
		}
	}
	
}