package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_1_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月29日 下午7:07:39
 * @description:方法内的变量为线程安全
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_1_Run {
	public static void main(String[] args) {

		// 共享numRef但是还是线程安全的情况
		Chp_2_1_1_HasSelfPrivateNum numRef = new Chp_2_1_1_HasSelfPrivateNum();
		Chp_2_1_1_ThreadA threadA = new Chp_2_1_1_ThreadA(numRef);
		Chp_2_1_1_ThreadB threadB = new Chp_2_1_1_ThreadB(numRef);

		threadA.start();
		threadB.start();
	}
}
