package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_8_3_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 下午5:36:31
 * @description: suspend与resume方法的缺点:不同步
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_8_3_Run {
	public static void main(String[] args) {
		final Chp_1_8_3_MyObject object = new Chp_1_8_3_MyObject();
		try {
			Thread thread1 = new Thread() {
				@Override
				public void run() {
					object.setValue("a", "aa");
				}
			};
			thread1.setName("a");
			thread1.start();
			Thread.sleep(500);

			Thread thread2 = new Thread() {
				@Override
				public void run() {
					object.printUsernamePassword();
				}
			};
			thread2.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
