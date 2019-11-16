package com.frankdevhub.foo.chp2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: Chp_2_3_5_AddCountThreadTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月16日 下午5:11:13
 * @description: 使用原子类进行i++操作
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_3_5_AddCountThreadTest {

	protected class AddCountThread extends Thread {
		private AtomicInteger count = new AtomicInteger(0);

		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				System.out.println(
						"threadName=" + Thread.currentThread().getName()
						+ " count=" + count.incrementAndGet());
			}
		}
	}

	// threadName=thread-A count=4994
	// threadName=thread-A count=4995
	// threadName=thread-A count=4996
	// threadName=thread-A count=4997
	// threadName=thread-A count=4998
	// threadName=thread-A count=4999
	// threadName=thread-A count=5000
	
	public static void main(String[] args) {
		
		Chp_2_3_5_AddCountThreadTest test = new Chp_2_3_5_AddCountThreadTest();
		AddCountThread addCountThread = test.new AddCountThread();

		Thread t1 = new Thread(addCountThread);
		t1.setName("thread-A");
		Thread t2 = new Thread(addCountThread);
		t2.setName("thread-B");
		Thread t3 = new Thread(addCountThread);
		t3.setName("thread-C");
		Thread t4 = new Thread(addCountThread);
		t4.setName("thread-D");
		Thread t5 = new Thread(addCountThread);
		t5.setName("thread-E");

		t1.start(); 
		t3.start();
		t4.start();
		t5.start();
		
	}
}
