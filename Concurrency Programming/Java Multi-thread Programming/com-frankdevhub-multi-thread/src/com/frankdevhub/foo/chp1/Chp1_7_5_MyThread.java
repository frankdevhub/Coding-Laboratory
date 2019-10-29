package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp1_7_5_MyThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月29日 下午6:56:23
 * @description: 强制暴力停止线程
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp1_7_5_MyThread extends Thread {

	private int i = 0;

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("running thread i=" + i);
				this.sleep(100);
				i++;
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Chp1_7_5_MyThread thread = new Chp1_7_5_MyThread();
		thread.start();
		Thread.sleep(2000);
		thread.stop();// stop方法会抛出java.lang.ThreadDeath异常,通常情况下不需要显示地捕捉
		System.out.println("end");
	}
}
