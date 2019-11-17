package com.frankdevhub.jdk.framework;

/**
 * @ClassName: JoinCountDownLatchTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月17日 下午9:57:13
 * @description: 等待多线程完成的JoinCountDownLatch
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class JoinCountDownLatchTest {

	// all parser finish
	// parser2 thread finish
	// parser1 thread finish

	public static void main(String[] args) throws InterruptedException {
		Thread parser1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("parser1 thread finish");
			}
		});

		Thread parser2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("parser2 thread finish");
			}
		});

		parser1.start();
		parser2.start();
		parser1.join();
		parser2.join();

		System.out.println("all parser finish");
	}
}
