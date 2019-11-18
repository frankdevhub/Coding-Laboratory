package com.frankdevhub.jdk.framework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierTest3
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月18日 下午4:00:34
 * @description: CyclicBarrier和CountDownLatch的区别
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class CyclicBarrierTest3 {

	static CyclicBarrier c = new CyclicBarrier(2);

	// Result: 抛出异常后回退重置
	
/********************************************************************************************************
	thread exception
	getNumber=0
	getNumber=0
	java.util.concurrent.BrokenBarrierException
		at java.util.concurrent.CyclicBarrier.dowait(Unknown Source)
		at java.util.concurrent.CyclicBarrier.await(Unknown Source)
		at com.frankdevhub.jdk.framework.CyclicBarrierTest3.main(CyclicBarrierTest3.java:37)
	java.lang.InterruptedException
	isBroken=true getNumber=0
		at java.util.concurrent.CyclicBarrier.dowait(Unknown Source)
		at java.util.concurrent.CyclicBarrier.await(Unknown Source)
		at com.frankdevhub.jdk.framework.CyclicBarrierTest3$1.run(CyclicBarrierTest3.java:23)
		at java.lang.Thread.run(Unknown Source)
********************************************************************************************************/
	
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					c.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					System.out.println("thread exception");
					System.out.println("getNumber=" + c.getNumberWaiting());
					e.printStackTrace();
				}
			}
		});

		thread.start();
		thread.interrupt();

		try {
			c.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
			System.out.println("isBroken=" + c.isBroken() + " getNumber=" + c.getNumberWaiting());
		}

	}
}
