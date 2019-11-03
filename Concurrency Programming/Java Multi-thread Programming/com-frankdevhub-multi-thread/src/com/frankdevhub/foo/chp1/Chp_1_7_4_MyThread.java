package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp1_7_4_MyThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月29日 下午6:32:10
 * @description:在沉睡中停止
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_7_4_MyThread extends Thread {

	@Override
	public void run() {
		super.run();

		try {
			for (int i = 0; i <= 10000; i++) {
				System.out.println("thread running i=" + i);
			}
			System.out.println("run begin");
			Thread.sleep(20000);
			System.out.println("run end");
		} catch (InterruptedException e) {
			System.out.println("run thread catch exception");

		}
	}

	public static void main(String[] args) {
		Chp_1_7_4_MyThread thread = new Chp_1_7_4_MyThread();
		thread.start();
		thread.interrupt();
	}

}
