package com.frankdevhub.foo.chp4;

/**
 * @ClassName: Chp_4_1_1_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月6日 下午10:23:39
 * @description: 使用ReentrantLock实现同步，测试1
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_4_1_1_Run {

	// Thread name=Thread-0 1
	// Thread name=Thread-0 2
	// Thread name=Thread-0 3
	// Thread name=Thread-0 4
	// Thread name=Thread-0 5
	// Thread name=Thread-1 1
	// Thread name=Thread-1 2
	// Thread name=Thread-1 3
	// Thread name=Thread-1 4
	// Thread name=Thread-1 5
	// Thread name=Thread-2 1
	// Thread name=Thread-2 2
	// Thread name=Thread-2 3
	// Thread name=Thread-2 4
	// Thread name=Thread-2 5
	// Thread name=Thread-3 1
	// Thread name=Thread-3 2
	// Thread name=Thread-3 3
	// Thread name=Thread-3 4
	// Thread name=Thread-3 5

	public static void main(String[] args) {
		Chp_4_1_1_MyService service = new Chp_4_1_1_MyService();
		Chp_4_1_1_MyThread a1 = new Chp_4_1_1_MyThread(service);
		Chp_4_1_1_MyThread a2 = new Chp_4_1_1_MyThread(service);
		Chp_4_1_1_MyThread a3 = new Chp_4_1_1_MyThread(service);
		Chp_4_1_1_MyThread a4 = new Chp_4_1_1_MyThread(service);

		a1.start();
		a2.start();
		a3.start();
		a4.start();

	}
}
