package com.frankdevhub.foo.chp4;

/**
 * @ClassName: Chp_4_1_1_MyThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月6日 下午10:23:03
 * @description: 使用ReentrantLock实现同步，测试1
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_4_1_1_MyThread extends Thread {

	private Chp_4_1_1_MyService service;

	public Chp_4_1_1_MyThread(Chp_4_1_1_MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.testMethod();
	}
}
