package com.ibm.mom.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/** 
 * LocksTest 
 * �ڶ��̱߳������һ����Ҫ�ĸ��������������һ����Դ�Ƕ���̹߳���ģ�Ϊ�˱�֤���ݵ������ԣ� 
 * �ڽ��������Բ���ʱ��Ҫ��������Դ�������������Ա�֤���������Բ���ʱֻ��һ���߳��ܶ���Դ���в����� 
 * �Ӷ���֤���ݵ�������.��5.0��ǰ�������Ĺ�������Synchronized�ؼ�����ʵ�ֵġ� 
 */  
public class LocksTest {  
      
    /** 
     * ����Lock��ʹ�á��ڷ�����ʹ��Lock�����Ա���ʹ��Synchronized�ؼ��֡� 
     */  
	public static class ReentrantLockTest {  
        Lock lock = new ReentrantLock();
        double value = 0d;
        int addtimes = 0;  
  
        /** 
         * ����value��ֵ���÷����Ĳ�����Ϊ2���������໥����������ʵ����һ�������� 
         * ���Ը÷�������ͬ������ǰ���������ڷ���������ʹ��Synchronized�ؼ��֡� 
         */  
        public void addValue(double v) {  
            lock.lock();				// ȡ����  
            System.out.println("ReentrantLockTest to addValue: " + v + "   " + System.currentTimeMillis());  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
            	e.printStackTrace();
            }  
            this.value += v;  
            this.addtimes++;  
            lock.unlock();			// �ͷ���  
        }  
  
        public double getValue() {  
            return this.value;  
        }  
    }  
    public static void testReentrantLockTest() throws Exception{  
        final ReentrantLockTest reentrantLockTest = new ReentrantLockTest();  
        
        // �½�����1������testReentrantLockTest��addValue����  
        Runnable task1 = new Runnable(){  
            public void run(){  
                reentrantLockTest.addValue(55.55);  
            }  
        };  
        
        // �½�����2������testReentrantLockTest��getValue����  
        Runnable task2 = new Runnable(){  
            public void run(){  
                System.out.println("ReentrantLockTest to get value==> " + reentrantLockTest.getValue());  
            }  
        };  
        
        // �½�����ִ�з���  
        ExecutorService cachedPool = Executors.newCachedThreadPool();  
        Future future = null;  
        // ͬʱִ������1���Σ�����addValue����ʹ���������ƣ����ԣ�ʵ���ϻ�˳��ִ��  
        for (int i=0; i<3; i++){  
            future = cachedPool.submit(task1);  
        }  
        // �ȴ����һ������1��ִ����  
        System.out.println("future.get(): " + future.get());
        
        // ��ִ������2��������  
        future = cachedPool.submit(task2);  
        
        // �ȴ�����2ִ����󣬹ر�����ִ�з���  
        System.out.println("future.get(): " + future.get());
        cachedPool.shutdownNow();  
    }  
      
    /** 
     * ReadWriteLock��������Lock:һ���Ƕ���Lock��һ����д��Lock�� 
     * ����߳̿�ͬʱ�õ�����Lock����ֻ��һ���߳��ܵõ�д��Lock������д��Lock���������κ��̶߳����ܵõ�Lock��
     * ReadWriteLock�ṩ�ķ����У� 
     * readLock(): ����һ������lock  
     * writeLock(): ����һ��д��lock, ��lock�������ġ� 
     * ReadWriteLock���ʺϴ��������ļ��Ķ�д������ 
     * ����ʱ�����ͬʱ����������д��д��ʱ��Ȳ���ͬʱдҲ���ܶ��� 
     */  
	public static class ReadWriteLockTest {
        ReadWriteLock lock = new ReentrantReadWriteLock();  
        double value = 0d;  
        int addtimes = 0;  
          
        /** 
         * ����value��ֵ�����������߳�ͬʱ����÷��� 
         */  
        public void addValue(double v) {  
            // �õ�writeLock������  
            Lock writeLock = lock.writeLock();  
            writeLock.lock();  
            System.out.println("ReadWriteLockTest to addValue: " + v + "   "  + System.currentTimeMillis());  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }  
            try {  
                // ��д�Ĺ���  
                this.value += v;  
                this.addtimes++;  
            } finally {  
                // �ͷ�writeLock��  
                writeLock.unlock();  
            }  
        }
        
        /** 
         * �����Ϣ�������߳��ڵ���addValue����ʱ��getInfo�õ�����Ϣ�����ǲ���ȷ�ġ� 
         * ���ԣ�Ҳ���뱣֤�÷����ڱ�����ʱ��û�з����ڵ���addValue������ 
         */  
        public String getValue() {  
            // �õ�readLock������  
            Lock readLock = lock.readLock();  
            readLock.lock();  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }  
            try {  
                // �����Ĺ���  
                return "value: " + this.value + ", items : " + this.addtimes;  
            } finally {  
                // �ͷ�readLock  
                readLock.unlock();  
            }  
        }  
    }  
      
    public static void testReadWriteLockTest() throws Exception{  
        final ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
        
		// �½�����1������lockTest��addValue����
		Runnable task_1 = new Runnable() {
			public void run() {
				readWriteLockTest.addValue(55.55);
			}
		};

		// �½�����2������lockTest��getValue����
		Runnable task_2 = new Runnable() {
			public void run() {
				System.out.println("ReadWriteLockTest to get value==> " + readWriteLockTest.getValue());
			}
		};
        
        // �½�����ִ�з���  
        ExecutorService cachedPool1 = Executors.newCachedThreadPool();  
        Future future_1 = null;  
        
		// ͬʱִ��5����������ǰ2��������task_1��������������task_2, ���һ��������task_1.
		for (int i = 0; i < 2; i++) {
			future_1 = cachedPool1.submit(task_1);
			future_1 = cachedPool1.submit(task_2);
		}
		future_1 = cachedPool1.submit(task_1);
        
        // ��5�������ִ��˳��Ӧ���ǣ�  
        // ��һ��task_1��ִ�У��ڶ���task_1��ִ�У�������Ϊ����ͬʱд�����Ա���ȡ�  
        // Ȼ��2��task_2ͬʱִ�У�������Ϊ��д��ʱ�򣬾Ͳ��ܶ������Զ��ȴ�д������  
        // ����Ϊ����ͬʱ������������ͬʱִ��  
        // ���һ��task_1��ִ�С�������Ϊ�ڶ���ʱ��Ҳ����д�����Ա���ȴ��������󣬲���д��  
          
        // �ȴ����һ��task_2��ִ���� 
		System.out.println("future.get(): " + future_1.get());
        cachedPool1.shutdown();  
    }  
  
    public static void main(String[] args) throws Exception{  
        System.out.println("-----------------------------ReentrantLockTest---------------------------------------------");  
        LocksTest.testReentrantLockTest();  
        System.out.println("-----------------------------ReadWriteLockTest---------------------------------------------");  
        LocksTest.testReadWriteLockTest();  
    }
    
}  