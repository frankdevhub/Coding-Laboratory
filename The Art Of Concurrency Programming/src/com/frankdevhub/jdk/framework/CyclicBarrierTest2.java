package com.frankdevhub.jdk.framework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierTest2
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月18日 上午9:02:37
 * @description: 同步屏障CyclicBarrier（优先执行barrierAction）
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class CyclicBarrierTest2 {

	public static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());

	public static class A implements Runnable {
		@Override
		public void run() {
			System.out.println("threadName=" + Thread.currentThread().getName() + " " + 3);
		}
	}

	protected class B extends Thread {
		@Override
		public void run() {
			System.out.println("threadName=" + Thread.currentThread().getName() + " b");
		}
	}

	public static void main(String[] args) {
		CyclicBarrierTest2 test2 = new CyclicBarrierTest2();
		Thread b = test2.new B();
		b.start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					cyclicBarrier.await();
					//System.out.println("threadName=" + Thread.currentThread().getName() + " " + 1);
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("threadName=" + Thread.currentThread().getName() + " " + 1);
			}
		}).start();

	/*	CyclicBarrierTest2 test2 = new CyclicBarrierTest2();
		Thread b = test2.new B();
		b.start();*/

		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

		System.out.println("threadName=" + Thread.currentThread().getName() + " " + 2);
	}
}
