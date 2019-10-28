package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp1_3_CountOperate
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月28日 下午11:11:34
 * @description: this.getName()和Thread.currentThread().getName()区别
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp1_3_CountOperate extends Thread {

	private class Chp1_3_CountOperate_Sub extends Thread {
		@Override
		public void run() {
			System.out.println("Chp1_3_CountOperate_Sub---begin");
			System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
			System.out.println("this.getName()=" + this.getName());
			System.out.println("Chp1_3_CountOperate_Sub--end");
		}

	}

	public Chp1_3_CountOperate() {
		System.out.println("Chp1_3_CountOperate---begin");
		System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
		System.out.println("this.getName()=" + this.getName());
		System.out.println("Chp1_3_CountOperate--end");
	}

	@Override
	public void run() {
		System.out.println("Thread run---begin");
		System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
		System.out.println("this.getName()=" + this.getName());
		System.out.println("Thread run--end");

		Chp1_3_CountOperate_Sub sub = new Chp1_3_CountOperate_Sub();
		sub.setName("sub");
		sub.start();

	}

	// return:
	// Chp1_3_CountOperate---begin
	// Thread.currentThread().getName()=main
	// this.getName()=Thread-0
	// Chp1_3_CountOperate--end
	// Thread run---begin
	// Thread.currentThread().getName()=thread
	// this.getName()=Thread-0
	// Thread run--end
	// Chp1_3_CountOperate_Sub---begin
	// Thread.currentThread().getName()=sub
	// this.getName()=sub
	// Chp1_3_CountOperate_Sub--end

	public static void main(String[] args) {
		Chp1_3_CountOperate test = new Chp1_3_CountOperate();
		Thread thread = new Thread(test);
		thread.setName("thread");
		test.start();

	}

}
