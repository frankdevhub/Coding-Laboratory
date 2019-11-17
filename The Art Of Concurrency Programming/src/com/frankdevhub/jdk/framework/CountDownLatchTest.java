package com.frankdevhub.jdk.framework;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: CountDownLatchTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月17日 下午11:05:56
 * @description: 使用CountDownLatch限制线程运行顺序并通知主线程
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */

// 1
// 2
// 3

public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch c = new CountDownLatch(2);

		Thread biz = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(1);
				c.countDown();

				System.out.println(2);
				c.countDown();
			}
		});

		biz.start();
		c.await();

		System.out.println(3);
	}
}
