package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_11_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 下午9:47:28
 * @description: 守护进程
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_11_Run {
	public static void main(String[] args) {
		try {
			Chp_1_11_MyThread thread = new Chp_1_11_MyThread();
			thread.setDaemon(true);
			thread.start();
			Thread.sleep(5000);
			System.out.println("main thread end,demaon thread ended");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
