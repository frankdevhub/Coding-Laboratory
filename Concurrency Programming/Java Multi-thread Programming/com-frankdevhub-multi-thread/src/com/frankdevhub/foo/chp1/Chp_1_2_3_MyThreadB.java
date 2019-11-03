package com.frankdevhub.foo.chp1;

/**
 * @ClassName: MyThread1
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月21日 下午10:10:27
 * @description: 实例变量与线程安全(线程之间的资源共享-线程不安全)
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_2_3_MyThreadB extends Thread {

	private int count = 5;

	@Override
	public void run() {
		super.run();
		System.out.println(Thread.currentThread().getName() + count);
		count--;
	}

	public static void main(String[] args) {
		Chp_1_2_3_MyThreadB myThread = new Chp_1_2_3_MyThreadB();
		Thread a = new Thread(myThread, "A");
		Thread b = new Thread(myThread, "B");
		Thread c = new Thread(myThread, "C");
		Thread d = new Thread(myThread, "D");
		Thread e = new Thread(myThread, "E");
		Thread f = new Thread(myThread, "F");

		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
		f.start();

	}

}
