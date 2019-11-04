package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp_1_8_2_1_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 下午3:16:54
 * @description: suspend与resume方法的缺点:独占
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_1_8_2_1_Run {

	protected class MyThread extends Thread {
		private long i = 0;

		@Override
		public void run() {
			while (true) {
				i++;
				//System.out.println("i=" + i);如果添加则PrintStream当前对象在打印时阻塞故主线程不能输出"end"
			}
		}
	}

	public static void main(String[] args) {
		try {
			Thread thread = new Chp_1_8_2_1_Run().new MyThread();
			// thread.setDaemon(true); 设置守护线程则不会独占死锁
			thread.start();
			Thread.sleep(1000);
			thread.suspend();
			System.out.println("main end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
