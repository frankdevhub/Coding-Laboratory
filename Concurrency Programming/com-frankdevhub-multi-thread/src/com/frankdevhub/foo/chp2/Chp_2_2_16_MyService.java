package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_2_16_MyService
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月15日 下午5:03:17
 * @description: 锁对象的改变
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_2_16_MyService {

	private String lock = "123";

	public void testMethod() {
		try {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() 
						+ " begin " + System.currentTimeMillis());
				lock = "456";
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() 
						+ " end " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
