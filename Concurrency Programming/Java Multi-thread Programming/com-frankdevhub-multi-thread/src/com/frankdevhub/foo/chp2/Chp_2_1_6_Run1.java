package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_6_Run1
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月7日 下午10:34:57
 * @description: 子类通过可重入锁调用父类方法
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_6_Run1 {

	public static void main(String[] args) {
		Chp_2_1_6_MyThread1 thread1 = new Chp_2_1_6_MyThread1();
		thread1.start();
	}
}
