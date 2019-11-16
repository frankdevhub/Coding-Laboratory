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

	protected class MyService {
		// 此处如果修改为
		// static AtomicLong aiRef = new AtomicLong(0L);
		// 可以保持原子性和方法调用均保持有序输出
		
		private AtomicLong aiRef = new AtomicLong(0L);

		public long getValue() {
			return aiRef.get();
		}
		
		synchronized public void addNum() {
			System.out.println("threadName="+Thread.currentThread().getName()
					+ " add 100 return value=" + aiRef.addAndGet(100));
			
			aiRef.addAndGet(1);
		}
	}

	protected class MyThread extends Thread {
		private MyService service;

		public MyThread(MyService service) {
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
			MyService service = test.new MyService();
			Thread[] threads = new Thread[5];
			
			for(int i=0;i<threads.length;i++){
			    threads[i] = test.new MyThread(service);
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
