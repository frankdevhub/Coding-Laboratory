package com.frankdevhub.jdk.framework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月18日 上午8:50:18
 * @description: 同步屏障CyclicBarrier
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class CyclicBarrierTest {

	// 因为主线程和子线程的调度是由CPU决定的，两个线程都有可能先执行，所以会产生两种输出结果

	// 1
	// 2
	// OR:
	// 2
	// 1

	public static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

	public static void main(String[] args) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					cyclicBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println(1);
			}

		}).start();

		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(2);
	}
}
