package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_3_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月5日 上午9:14:23
 * @description: 多个对象多个锁
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_3_Run {
	// a set over!
	// a num=100
	// b set over!
	// b num=200

	public static void main(String[] args) {
		Chp_2_1_3_HasSelfPrivateNum numRef = new Chp_2_1_3_HasSelfPrivateNum();
		Chp_2_1_3_ThreadA threadA = new Chp_2_1_3_ThreadA(numRef);
		threadA.setName("a");
		Chp_2_1_3_ThreadB threadB = new Chp_2_1_3_ThreadB(numRef);
		threadB.setName("b");

		threadA.start();
		threadB.start();

	}
}
