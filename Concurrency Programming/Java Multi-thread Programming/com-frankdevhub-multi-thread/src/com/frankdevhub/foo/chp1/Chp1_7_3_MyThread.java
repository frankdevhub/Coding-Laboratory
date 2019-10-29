package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp1_7_3_MyThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月29日 下午6:10:47
 * @description: 使用异常法停止线程
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp1_7_3_MyThread extends Thread {

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		try {
			for (int i = 0; i <= 5000000; i++) {
				if (this.interrupted()) {
					System.out.println("current thread is interrupted");
					// 如果使用break函数体剩余内容仍会运行
					throw new InterruptedException(); // 抛出异常终止
				}
				System.out.println("thread running,i=" + i);
			}
			System.out.println("after loop");
		} catch (Exception e) {
			System.out.println("loop end and getinto catch block");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		try {

			Chp1_7_3_MyThread thread = new Chp1_7_3_MyThread();

			thread.start();
			thread.sleep(2000);
			thread.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
