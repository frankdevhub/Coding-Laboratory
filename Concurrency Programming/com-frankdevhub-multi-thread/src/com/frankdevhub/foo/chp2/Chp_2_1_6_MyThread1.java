package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_6_MyThread1
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月7日 下午10:35:55
 * @description: 子类通过可重入锁调用父类方法
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_6_MyThread1 extends Thread {

	@Override
	public void run() {
		Chp_2_1_6_Sub sub = new Chp_2_1_6_Sub();
		sub.operateISubMethod();
	}
}
