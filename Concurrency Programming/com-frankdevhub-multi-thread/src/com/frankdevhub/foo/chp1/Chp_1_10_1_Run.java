package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_10_1_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 下午6:43:21
 * @description: 线程优先级的继承特性
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_10_1_Run {
	public static void main(String[] args) {

		// 添加修改
		// main thread begin priority=5
		// main thread end priority=6
		// MyThread1 run priority=6
		// MyThread2 run priority=6

		// 不添加修改
		// main thread begin priority=5
		// main thread end priority=5
		// MyThread1 run priority=5
		// MyThread2 run priority=5

		System.out.println("main thread begin priority=" + Thread.currentThread().getPriority());
		// Thread.currentThread().setPriority(6);// 如果设置则继承修改后的优先值
		System.out.println("main thread end priority=" + Thread.currentThread().getPriority());

		Chp_1_10_1_MyThread1 thread = new Chp_1_10_1_MyThread1();
		thread.start();
	}
}
