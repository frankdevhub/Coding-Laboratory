package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_8_Task
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月15日 上午1:59:50
 * @description: synchronized方法的弊端
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_8_Task {
	private String getData1;
	private String getData2;

	public synchronized void doLongTask() {
		try {
			System.out.println("begin task");
			Thread.sleep(3000);
			getData1 = "do long task return value 1 threadName=" + Thread.currentThread().getName();
			getData2 = "do long task return value 1 threadName=" + Thread.currentThread().getName();

			System.out.println(getData1);
			System.out.println(getData2);

			System.out.println("end task");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
