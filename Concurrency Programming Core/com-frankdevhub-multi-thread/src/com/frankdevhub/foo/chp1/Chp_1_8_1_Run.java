package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_8_1_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 上午11:37:52
 * @description: suspend与resume方法的使用:暂停与恢复线程
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_8_1_Run {
	public static void main(String[] args) {
		try {
			Chp_1_8_1_MyThread thread = new Chp_1_8_1_MyThread();
			thread.start();
			Thread.sleep(5000);
			// A段
			thread.suspend();
			System.out.println("A=" + System.currentTimeMillis() + "i=" + thread.getI());
			thread.sleep(5000);
			System.out.println("A=" + System.currentTimeMillis() + "i=" + thread.getI());
			// B段
			thread.resume();
			Thread.sleep(5000);
			// C段
			thread.suspend();
			System.out.println("B=" + System.currentTimeMillis() + "i=" + thread.getI());
			thread.sleep(5000);
			System.out.println("B=" + System.currentTimeMillis() + "i=" + thread.getI());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
