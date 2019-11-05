package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_4_MyObject
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月5日 下午1:55:54
 * @description: synchronized方法锁与对象
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_4_MyObject {
	synchronized public void method() {
		try {
			System.out.println("method begin threadName=" + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
