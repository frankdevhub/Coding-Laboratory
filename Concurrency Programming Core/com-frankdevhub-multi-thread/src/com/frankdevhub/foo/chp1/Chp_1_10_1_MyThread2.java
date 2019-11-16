package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_10_1_MyThread2
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 下午6:42:00
 * @description: 线程优先级的继承特性
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_10_1_MyThread2 extends Thread {
	@Override
	public void run() {
		System.out.println("MyThread2 run priority=" + this.getPriority());
	}
}
