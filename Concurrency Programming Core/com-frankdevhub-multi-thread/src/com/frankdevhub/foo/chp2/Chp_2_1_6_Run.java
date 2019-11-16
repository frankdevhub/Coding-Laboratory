package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_6_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月7日 下午9:59:49
 * @description: synchronized锁重入
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_6_Run {

	// Thread-0 do service1
	// Thread-0 do service2
	// Thread-0 do service3

	public static void main(String[] args) {
		Thread thread = new Chp_2_1_6_MyThread();
		thread.start();
	}
}
