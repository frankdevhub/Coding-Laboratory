package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_4_MyThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月28日 下午11:32:58
 * @description: isAlive()方法
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_4_MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("run=" + this.isAlive());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("run finish.");
	}

	// return:
	// begin==false
	// begin==false
	// thread do sleep==false
	// run=true
	// run finish.

	public static void main(String[] args) {
		Chp_1_4_MyThread thread = new Chp_1_4_MyThread();
		System.out.println("begin==" + thread.isAlive());

		System.out.println("begin==" + thread.isAlive());
		System.out.println("thread do sleep==" + thread.isAlive());

		thread.start();
	}
}
