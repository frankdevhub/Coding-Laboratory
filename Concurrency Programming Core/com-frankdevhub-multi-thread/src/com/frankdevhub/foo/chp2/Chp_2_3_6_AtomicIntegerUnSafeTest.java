package com.frankdevhub.foo.chp2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName: Chp_2_3_6_AtomicIntegerUnSafeTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月16日 下午5:26:23
 * @description: 原子类也并不完全安全:方法与方法之间的调用有可能顺序错误
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */

public class Chp_2_3_6_AtomicIntegerUnSafeTest {

	protected class MyThread extends Thread {
		private Chp_2_3_6_AtomicIntegerService service;

		public MyThread(Chp_2_3_6_AtomicIntegerService service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			service.addNum();
		}
	}

	// threadName=Thread-2 add 100 return value=200
	// threadName=Thread-4 add 100 return value=500
	// threadName=Thread-3 add 100 return value=300
	// threadName=Thread-0 add 100 return value=100
	// threadName=Thread-1 add 100 return value=400
	// last value print in main=505

	public static void main(String[] args) {
		try {
			Chp_2_3_6_AtomicIntegerUnSafeTest test = new Chp_2_3_6_AtomicIntegerUnSafeTest();
			Chp_2_3_6_AtomicIntegerService service = new Chp_2_3_6_AtomicIntegerService();
			Thread[] threads = new Thread[5];

			for (int i = 0; i < threads.length; i++) {
				threads[i] = test.new MyThread(service);
				threads[i].setName("thread-[" + (i + 1) + "]");
			}

			for (int j = 0; j < threads.length; j++) {
				threads[j].start();
			}

			Thread.sleep(1000);

			System.out.println("last value print in main=" + service.getValue());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
