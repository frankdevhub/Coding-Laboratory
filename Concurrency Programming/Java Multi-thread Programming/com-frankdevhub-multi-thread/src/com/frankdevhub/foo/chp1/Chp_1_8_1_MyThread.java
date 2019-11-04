package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_8_1_MyThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 上午11:34:43
 * @description: suspend与resume方法的使用:暂停与恢复线程
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_8_1_MyThread extends Thread {

	private long i = 0;

	public long getI() {
		return i;
	}

	public void setI(long i) {
		this.i = i;
	}

	@Override
	public void run() {
		while (true) {
			i++;
		}
	}
}
