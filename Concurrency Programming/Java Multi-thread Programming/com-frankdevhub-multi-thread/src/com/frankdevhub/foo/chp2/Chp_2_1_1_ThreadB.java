package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_1_ThreadB
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月29日 下午7:07:32
 * @description:方法内的变量为线程安全
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_1_ThreadB extends Thread {

	private Chp_2_1_1_HasSelfPrivateNum numRef;

	public Chp_2_1_1_ThreadB(Chp_2_1_1_HasSelfPrivateNum numRef) {
		super();
		this.numRef = numRef;
	}

	@Override
	public void run() {
		super.run();
		numRef.addI("b");
	}
}
