package com.frankdevhub.foo.chp1;

/**
 * @ClassName: MyThread3
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月23日 下午7:09:03
 * @description: System.out.println()非线程安全
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_2_4_MyThread extends Thread {

	private int i = 5;

	@Override
	public void run() {
		System.out.println("i=" + i-- + Thread.currentThread().getName());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Chp_1_2_4_MyThread run = new Chp_1_2_4_MyThread();
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		Thread t3 = new Thread(run);
		Thread t4 = new Thread(run);
		Thread t5 = new Thread(run);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}
}
