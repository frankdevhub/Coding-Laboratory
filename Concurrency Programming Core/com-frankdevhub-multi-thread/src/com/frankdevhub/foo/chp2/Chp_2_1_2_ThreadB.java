package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_2_ThreadB
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月3日 下午11:04:10
 * @description: 实例变量非线程安全
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_2_ThreadB extends Thread {
	private Chp_2_1_2_HasSelfPrivateNum numRef;

	public Chp_2_1_2_ThreadB(Chp_2_1_2_HasSelfPrivateNum numRef) {
		super();
		this.numRef = numRef;
	}

	@Override
	public void run() {
		super.run();
		numRef.addI("b");
	}
}
