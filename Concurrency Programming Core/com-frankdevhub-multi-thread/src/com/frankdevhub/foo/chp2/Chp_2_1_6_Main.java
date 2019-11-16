package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_6_Main
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月7日 下午10:23:50
 * @description: 子类通过可重入锁调用父类方法
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_6_Main {

	public int i = 10;

	synchronized public void operateIMainMethod() {
		try {
			i--;
			System.out.println(Thread.currentThread().getName() + " Main print i=" + i);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
