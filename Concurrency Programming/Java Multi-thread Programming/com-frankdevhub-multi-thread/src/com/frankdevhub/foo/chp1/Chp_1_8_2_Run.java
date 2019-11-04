package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_8_2_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 上午11:47:40
 * @description: suspend与resume方法的缺点:独占
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_8_2_Run {
	public static void main(String[] args) {
		try {
			final Chp_1_8_2_SynchronizedObject object = new Chp_1_8_2_SynchronizedObject();
			Thread thread1 = new Thread() {

				@Override
				public void run() {
					object.printString();
				}
			};
			thread1.setName("a");
			thread1.start();
			Thread.sleep(1000);

			Thread thread2 = new Thread() {

				@Override
				public void run() {
					System.out.println("thread2 is started but cannot invoke object's printString method");
					System.out.println("method is locked because thread1 has been suspended");

					object.printString();
				}
			};
			thread2.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
