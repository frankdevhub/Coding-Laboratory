package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_6_Service
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月7日 下午9:59:08
 * @description: synchronized锁重入
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_6_Service {
	synchronized public void service1() {
		System.out.println(Thread.currentThread().getName() + " do service1");
		service2();
	}

	synchronized public void service2() {
		System.out.println(Thread.currentThread().getName() + " do service2");
		service3();
	}

	synchronized public void service3() {
		System.out.println(Thread.currentThread().getName() + " do service3");
	}
}
