package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_4_ThreadB
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月5日 下午9:27:21
 * @description: synchronized方法锁与对象
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_4_ThreadB extends Thread {

	private Chp_2_1_4_MyObject object;

	public Chp_2_1_4_ThreadB(Chp_2_1_4_MyObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.method();
	}
}
