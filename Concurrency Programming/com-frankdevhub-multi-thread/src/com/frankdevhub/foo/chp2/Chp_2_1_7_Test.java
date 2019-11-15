package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_7_Test
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月7日 下午10:55:41
 * @description: 出现异常，锁自动释放
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_7_Test {

	protected class ThreadA extends Thread {

		Chp_2_1_7_Service service;

		public ThreadA(Chp_2_1_7_Service service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			service.testMethod();
		}
	}

	protected class ThreadB extends Thread {

		Chp_2_1_7_Service service;

		public ThreadB(Chp_2_1_7_Service service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			service.testMethod();
		}
	}

	public static void main(String[] args) {
		try {
			Chp_2_1_7_Service service = new Chp_2_1_7_Service();
			Thread threadA = new Chp_2_1_7_Test().new ThreadA(service);
			threadA.setName("a");
			threadA.start();

			Thread.sleep(500);
			Thread threadB = new Chp_2_1_7_Test().new ThreadB(service);
			threadB.setName("b");
			threadB.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
