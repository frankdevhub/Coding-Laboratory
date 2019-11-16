package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_2_14_SynInnerTest2
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月15日 上午11:53:50
 * @description: 内置类与同步2:对同一个静态类上锁，其他线程只能同步的方式调用被锁类中的静态方法
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_2_14_SynInnerTest2 {
	static class InnerClass1 {
		public void method1(InnerClass2 class2) {
			String threadName = Thread.currentThread().getName();

			synchronized (class2) {
				System.out.println(threadName + " get into InnerClass1 method1");
				for (int i = 0; i < 10; i++) {
					System.out.println("i=" + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(threadName + " get outof InnerClass1 method1");
			}
		}

		synchronized public void method2() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " get into InnerClass1 method2");

			for (int j = 0; j < 10; j++) {
				System.out.println("j=" + j);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(threadName + " get outof InnerClass1 method2");
		}
	}

	static class InnerClass2 {
		synchronized public void method1() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " get into InnerClass2 method1");

			for (int k = 0; k < 10; k++) {
				System.out.println("k=" + k);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(threadName + " get outof InnerClass2 method1");
		}
	}

	public static void main(String[] args) {
		final InnerClass1 innerClass1 = new InnerClass1();
		final InnerClass2 innerClass2 = new InnerClass2();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				innerClass1.method1(innerClass2);
				;
			}
		}, "T1");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				innerClass1.method2();
			}
		}, "T2");

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				innerClass2.method1();
			}
		}, "T3");

		t1.start();
		t2.start();
		t3.start();
	}
}
