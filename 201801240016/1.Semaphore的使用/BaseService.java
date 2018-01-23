package com.base.test;

import java.util.concurrent.Semaphore;

//fangchensheng start 2018/1/14 Semaphore的使用

public class BaseService {
	private Semaphore semaphore = new Semaphore(1);

	public void testMethod() throws InterruptedException {
		semaphore.acquire();
		System.out.println(Thread.currentThread().getName() + "\tbegin time:" + System.currentTimeMillis());
		System.out.println("simple  biz");
		Thread.sleep(5000);
		System.out.println(Thread.currentThread().getName() + "\tend time:" + System.currentTimeMillis());
		semaphore.release();
	}
}
