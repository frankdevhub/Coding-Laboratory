package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_10_3_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 下午9:35:29
 * @description: 优先级具有随机性
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_10_3_Run {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Chp_1_10_3_MyThread1 thread1 = new Chp_1_10_3_MyThread1();
			thread1.setPriority(5);
			thread1.start();
			Chp_1_10_3_MyThread2 thread2 = new Chp_1_10_3_MyThread2();
			thread2.setPriority(6);
			thread2.start();
		}
	}
}
