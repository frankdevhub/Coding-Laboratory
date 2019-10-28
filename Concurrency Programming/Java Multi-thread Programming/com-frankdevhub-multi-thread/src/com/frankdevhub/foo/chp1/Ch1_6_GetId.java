package com.frankdevhub.foo.chp1;

/**
 * @ClassName: Ch1_6_GetId
 * @author: frankdevhub@gmail.com
 * @date: 2019年10月28日 下午11:47:27
 * @description: getId()方法 
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Ch1_6_GetId extends Thread {

	//Thread.currentThread()情况下并不会执行
	@Override
	public void run() {
		System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
		System.out.println("this.getName()=" + this.getName());
		System.out.println("CurrentThreadId=" + Thread.currentThread().getId());
		System.out.println("this.getId()=" + this.getId());
	}

	//return 
	//main-> thread.getName()=main	 main this.getId()=1
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getId());
		Thread thread = Thread.currentThread(); 
		System.out.println(thread==Thread.currentThread());
		//thread.start(); // Thread.currentThread()方法时会java.lang.IllegalThreadStateException
		System.out.println("main-> thread.getName()=" + thread.getName() + "\t main this.getId()=" + thread.getId());
	}
}
