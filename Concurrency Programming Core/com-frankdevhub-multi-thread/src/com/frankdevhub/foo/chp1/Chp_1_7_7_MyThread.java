package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_7_7_MyThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月3日 下午11:14:53
 * @description: 释放锁的不良后果:强制stop导致数据不一致
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_7_7_MyThread extends Thread {
	private Chp_1_7_7_SynchronizedObject object;

	public Chp_1_7_7_MyThread(Chp_1_7_7_SynchronizedObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		object.printString("b", "bb");
	}
}
