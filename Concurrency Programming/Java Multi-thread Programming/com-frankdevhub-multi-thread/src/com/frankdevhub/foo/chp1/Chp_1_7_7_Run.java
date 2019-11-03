package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_7_7_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月3日 下午11:15:43
 * @description: 释放锁的不良后果:强制stop导致数据不一致
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_7_7_Run {

	public static void main(String[] args) {

		try {
			Chp_1_7_7_SynchronizedObject object = new Chp_1_7_7_SynchronizedObject();
			Chp_1_7_7_MyThread thread = new Chp_1_7_7_MyThread(object);

			thread.start();
			thread.sleep(500);
			thread.stop();
			System.out.println(object.getUserName() + " " + object.getPassword());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
