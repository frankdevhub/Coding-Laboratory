package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_8_Main
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月15日 上午12:32:03
 * @description: 同步不具有继承性
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_8_Main {
	synchronized public void serviceMethod() {
		try {
			System.out.println("int main next sleep begin threadName=" + Thread.currentThread().getName() + " time="
					+ System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int main next sleep end threadName=" + Thread.currentThread().getName() + " time="
					+ System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
