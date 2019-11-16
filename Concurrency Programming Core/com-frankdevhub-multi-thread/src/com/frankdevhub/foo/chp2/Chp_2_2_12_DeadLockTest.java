package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_2_11_DeadLockTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月15日 上午11:04:29
 * @description: 多线程的死锁
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_2_12_DeadLockTest {

	protected class DeadThread implements Runnable {
		private String username;
		private Object lock1 = new Object();
		private Object lock2 = new Object();

		public void setFlag(String username) {
			this.username = username;
		}

		@Override
		public void run() {
			if (username.toLowerCase().equals("a")) {
				synchronized (lock1) {
					try {
						Thread.sleep(1000);
						System.out.println("username=" 
						     + username + " threadName=" 
								+ Thread.currentThread().getName());
						Thread.sleep(3000);
						
						synchronized (lock2) {
							System.out.println("username=a do lock2->lock1");
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if (username.toLowerCase().equals("b")) {
				synchronized (lock2) {
					try {
						System.out.println("username=" 
				          	+ username + " threadName=" 
								+ Thread.currentThread().getName());
						Thread.sleep(3000);
						
						synchronized (lock1) {
							System.out.println("username=a do lock2->lock1");
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			Chp_2_2_12_DeadLockTest deadLockTest = new Chp_2_2_12_DeadLockTest();
			DeadThread deadLockThread = deadLockTest.new DeadThread();
			Thread t1 = new Thread(deadLockThread);
			Thread t2 = new Thread(deadLockThread);
			deadLockThread.setFlag("a");

			t1.start();
			Thread.sleep(100);

			deadLockThread.setFlag("b");
			t2.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
