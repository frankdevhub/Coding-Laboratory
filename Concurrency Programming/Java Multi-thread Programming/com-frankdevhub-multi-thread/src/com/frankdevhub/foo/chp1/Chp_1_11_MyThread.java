package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_11_MyThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 下午9:44:09
 * @description: 守护进程
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_11_MyThread extends Thread {

	private int i = 0;

	@Override
	public void run() {
		try {
			while (true) {
				i++;
				System.out.println("i=" + (i));
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
