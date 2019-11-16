package com.frankdevhub.foo.chp4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: Chp_4_1_1_MyService
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月6日 下午10:22:12
 * @description: 使用ReentrantLock实现同步，测试1
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_4_1_1_MyService {

	private Lock lock = new ReentrantLock();

	public void testMethod() {
		lock.lock();
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread name=" + Thread.currentThread().getName() + " " + (i + 1) + "");
		}
		lock.unlock();
	}
}
