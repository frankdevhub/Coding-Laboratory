package com.frankdevhub.foo.chp3;

/**
 * @ClassName: Chp_3_1_1_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月6日 上午9:09:03
 * @description: 不使用等待/通知机制实现线程间通信
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_3_1_1_Run {

	public static void main(String[] args) {
		Chp_3_1_1_MyList list = new Chp_3_1_1_MyList();
		Chp_3_1_1_ThreadA threadA = new Chp_3_1_1_ThreadA(list);
		Chp_3_1_1_ThreadB threadB = new Chp_3_1_1_ThreadB(list);

		threadA.setName("A");
		threadA.start();

		threadB.setName("B");
		threadB.start();
	}
}
