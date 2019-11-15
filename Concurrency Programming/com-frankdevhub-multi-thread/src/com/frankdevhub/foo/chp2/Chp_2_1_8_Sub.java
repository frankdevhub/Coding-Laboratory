package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_8_Sub
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月15日 上午12:36:04
 * @description: 同步不具有继承性
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_8_Sub extends Chp_2_1_8_Main {
	// synchronized此处关键字不加不能实现调用子类方法同步
	public void serviceMethod() {
		try {
			System.out.println("int sub next sleep begin threadName=" + Thread.currentThread().getName() + " time="
					+ System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int sub next sleep end threadName=" + Thread.currentThread().getName() + " time="
					+ System.currentTimeMillis());

			super.serviceMethod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
