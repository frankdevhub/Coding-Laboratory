package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp1_3_CurrentThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月28日 上午1:29:22
 * @description: Thread.currentThread()方法的使用
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_3_CurrentThread extends Thread {

	public Chp_1_3_CurrentThread() {
		System.out.println("[constructor]running current thread name:" + Thread.currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println("[do run]running current thread name:" + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		// Thread test = new Thread(new Chp1_3_CurrentThread());
		Chp_1_3_CurrentThread test = new Chp_1_3_CurrentThread();
		// test.start(); //由 test对应线程调用，返回Thread-0
		test.run(); // 直接由main方法调用，返回main
	}
}
