package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp1_7_1_MyThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月29日 上午11:39:38
 * @description: interrupt()方法标记线程终止但是不能中断线程
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_7_1_MyThread extends Thread {

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 50000; i++) {
			System.out.println("Thread runing: " + i);
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Chp_1_7_1_MyThread thread = new Chp_1_7_1_MyThread();

		try {
			thread.start();
			System.out.println("start sleep");
			thread.interrupt();
			thread.sleep(2000);

			System.out.println("after sleep");
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
	}
}
