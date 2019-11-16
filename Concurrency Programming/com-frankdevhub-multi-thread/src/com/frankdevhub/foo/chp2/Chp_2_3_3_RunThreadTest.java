package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_3_3_RunThreadTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月16日 下午12:40:11
 * @description: 线程公共栈和私有栈不同步导致的死循环
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_3_3_RunThreadTest {

	protected class RunThread extends Thread {
		// 此处应使用volatile使得公有与私有的数据栈数据同步
		// volatile private boolean isRunning = true;

		private boolean isRunning = true;

		public void setRunning(boolean isRunning) {
			this.isRunning = isRunning;
		}

		@Override
		public void run() {
			System.out.println("invoke run method");
			while (isRunning) {
				// try {
				// System.out.println("loop threadName=" +
				// Thread.currentThread().getName());
				// Thread.sleep(100);

				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
			}
			System.out.println("end run method");
		}
	}

	// 当while循环占据优先权不断循环时，线程读取的私有栈数据，
	// 并未读取线程共有栈中的主内存中的数据导致数据不一致造成死循环
	public static void main(String[] args) {
		try {
			Chp_2_3_3_RunThreadTest runThreadTest = new Chp_2_3_3_RunThreadTest();
			RunThread runThread = runThreadTest.new RunThread();

			runThread.start();
			Thread.sleep(1000);
			runThread.setRunning(false);
			System.out.println("set isRunning as false");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
