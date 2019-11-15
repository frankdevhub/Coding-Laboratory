package com.frankdevhub.foo.chp4;

/**
 * @ClassName: Chp_4_1_2_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月6日 下午10:49:26
 * @description: 使用ReentrantLock实现同步，测试2
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_4_1_2_Run {

	protected class ThreadA extends Thread {

		private Chp_4_1_2_MyService service;

		protected ThreadA(Chp_4_1_2_MyService service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			service.methodA();
		}
	}

	protected class ThreadAA extends Thread {

		private Chp_4_1_2_MyService service;

		protected ThreadAA(Chp_4_1_2_MyService service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			service.methodA();
		}
	}

	protected class ThreadB extends Thread {

		private Chp_4_1_2_MyService service;

		protected ThreadB(Chp_4_1_2_MyService service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			service.methodB();
		}
	}

	protected class ThreadBB extends Thread {

		private Chp_4_1_2_MyService service;

		protected ThreadBB(Chp_4_1_2_MyService service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			service.methodB();
		}
	}

	// methodA begin thread name=A time=1573052464138
	// methodA end thread name=A time=1573052469139
	// methodA begin thread name=AA time=1573052469139
	// methodA end thread name=AA time=1573052474139
	// methodB begin thread name=B time=1573052474139
	// methodB end thread name=B time=1573052479139
	// methodB begin thread name=BB time=1573052479139
	// methodB end thread name=BB time=1573052484141

	public static void main(String[] args) {

		Chp_4_1_2_MyService service = new Chp_4_1_2_MyService();
		Thread a = new Chp_4_1_2_Run().new ThreadA(service);
		a.setName("A");
		Thread aa = new Chp_4_1_2_Run().new ThreadAA(service);
		aa.setName("AA");
		Thread b = new Chp_4_1_2_Run().new ThreadB(service);
		b.setName("B");
		Thread bb = new Chp_4_1_2_Run().new ThreadBB(service);
		bb.setName("BB");

		a.start();
		aa.start();
		b.start();
		bb.start();

	}
}
