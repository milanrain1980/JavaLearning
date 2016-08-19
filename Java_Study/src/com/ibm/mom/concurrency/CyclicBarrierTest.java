package com.ibm.mom.concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *	使用场景：一个主线程获取数据，有两个子线程分别处理主线程获取的数据，
 * 					当两个子线程都处理完毕后再获取下一个数据进行处理
 * 使用说明：对一个数据可以使用多个线程同时处理，当所有线程都处理完毕后通知主线程开始下一个数据的处理
 */
public class CyclicBarrierTest implements Runnable {
	private CyclicBarrier barrier = new CyclicBarrier(3);
	private String tourName;
	private int sleepTime;
    private ExecutorService es = Executors.newFixedThreadPool(3);

    public CyclicBarrierTest() {
        new CyclicBarrierTest(barrier, "1 主线程", 0);
    }

    public CyclicBarrierTest(CyclicBarrier barrier, String tourName, int sleepTime) {
    	this.barrier = barrier;
    	this.tourName = tourName;
        this.sleepTime = sleepTime;
        es.submit(this);
    }

    @Override
    public void run() {
        while (true) {
            try {
                //主线程，获取数据分发给两个子线程同时处理
                System.out.println(now() + "1 - 主线程获得 数据");
                //分发给第一个子线程处理数据
                es.submit(new WriteFile(barrier, "2 - 子线程处理 数据 入库", 1));
                //分发给第二个子线程处理数据
                es.submit(new WriteFile(barrier, "3 - 子线程处理 数据 写文件", 1));
                //等待信号，当所有子线程处理完毕解除同步。
                barrier.await();
                System.out.println("----------------一个 数据 使用 2个子线程处理完毕-----------------");
                Thread.sleep(sleepTime * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        new CyclicBarrierTest();
    }

    static String now() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date()) + ": ";
    }

    static class WriteFile implements Runnable {
    	private CyclicBarrier barrier;
    	private String tourName;
        private int sleepTime;

        public WriteFile(CyclicBarrier barrier, String tourName, int sleepTime) {
        	this.barrier = barrier;
        	this.tourName = tourName;
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(sleepTime * 1000);
                System.out.println(now() + tourName);
                barrier.await();
            } catch (InterruptedException e) {
            	e.printStackTrace();
            } catch (BrokenBarrierException e) {
            	e.printStackTrace();
            }
        }
    }

}

