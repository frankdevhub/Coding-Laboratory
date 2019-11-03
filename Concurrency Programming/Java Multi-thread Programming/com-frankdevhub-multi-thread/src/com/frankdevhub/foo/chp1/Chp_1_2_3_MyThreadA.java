package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp1_2_3_MyThreadA
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月28日 上午1:17:32
 * @description: 实例变量与线程安全(线程之间的资源共享-线程安全)
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_2_3_MyThreadA extends Thread {

	private int count = 5;

	public Chp_1_2_3_MyThreadA(String name) {
		super();
		this.setName(name);
	}

	@Override
	public void run() {
		while (count > 0) {
			System.out.println(Thread.currentThread().getName() + ":" + count);
			count--;
		}
	}

	public static void main(String[] args) {
		Chp_1_2_3_MyThreadA a = new Chp_1_2_3_MyThreadA("A");
		Chp_1_2_3_MyThreadA b = new Chp_1_2_3_MyThreadA("B");
		Chp_1_2_3_MyThreadA c = new Chp_1_2_3_MyThreadA("C");

		a.start();
		b.start();
		c.start();
	}

}
