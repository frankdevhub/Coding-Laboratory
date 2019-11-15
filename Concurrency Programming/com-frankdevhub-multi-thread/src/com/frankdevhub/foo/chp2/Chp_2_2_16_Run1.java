package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_2_16_Run1
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月15日 下午5:52:35
 * @description: 锁对象的改变
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_2_16_Run1 {
	protected class ThreadA extends Thread {
		private Chp_2_2_16_MyService service;

		public ThreadA(Chp_2_2_16_MyService service) {
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
		private Chp_2_2_16_MyService service;

		public ThreadB(Chp_2_2_16_MyService service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			service.testMethod();
		}
	}

	// A begin 1573812341382
	// A end 1573812343382
	// B begin 1573812343382
	// B end 1573812345384

	public static void main(String[] args) {
		Chp_2_2_16_Run1 run = new Chp_2_2_16_Run1();
		Chp_2_2_16_MyService service = new Chp_2_2_16_MyService();

		Thread threadA = run.new ThreadA(service);
		threadA.setName("A");
		Thread threadB = run.new ThreadA(service);
		threadB.setName("B");

		threadA.start();
		threadB.start();
	}
}
