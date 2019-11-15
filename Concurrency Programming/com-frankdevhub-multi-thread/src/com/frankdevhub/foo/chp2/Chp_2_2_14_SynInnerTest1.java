package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_2_14_SynInnerTest1
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月15日 上午11:33:12
 * @description: 内置类与同步1:内置类中两个同步方法使用不同的锁
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_2_14_SynInnerTest1 {
	static class InnerClass {
		public void method1() {
			synchronized ("other lock") {
				for (int i = 0; i < 10; i++) {
					try {
						System.out.println("threadName=" + Thread.currentThread().getName()
								+ " i=" + i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		synchronized public void method2() {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("threadName=" + Thread.currentThread().getName()
							+ " i=" + i);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// threadName=A i=0
	// threadName=B i=0
	// threadName=A i=1
	// threadName=B i=1
	// threadName=B i=2
	// threadName=A i=2
	// threadName=B i=3
	// threadName=A i=3
	// threadName=B i=4
	// threadName=A i=4
	// threadName=B i=5
	// threadName=A i=5
	// threadName=B i=6
	// threadName=A i=6
	// threadName=B i=7
	// threadName=A i=7
	// threadName=B i=8
	// threadName=A i=8
	// threadName=B i=9
	// threadName=A i=9
	
	public static void main(String[] args) {
		final InnerClass inner = new InnerClass();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				inner.method1();
			}
		}, "A");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				inner.method2();
			}
		}, "B");
		
		t1.start();
		t2.start();
	}
}
