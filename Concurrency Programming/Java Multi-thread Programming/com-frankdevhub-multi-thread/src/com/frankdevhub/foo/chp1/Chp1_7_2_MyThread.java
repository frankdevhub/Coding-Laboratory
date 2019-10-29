package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Chp1_7_2_MyThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月29日 下午1:59:13
 * @description: Thread.interrupted()多次调用的结果
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp1_7_2_MyThread extends Thread {

	public static void main(String[] args) {
		Thread.currentThread().interrupt();
		System.out.println("current Thread is interruped=" + Thread.interrupted());
		System.out.println("current Thread is interruped=" + Thread.interrupted());// 第二次调用时清楚上次Thread.currentThread().interrupt()产生的标记
		System.out.println("current Thread is interruped=" + Thread.interrupted());//保持不变
	}
}
