package com.frankdevhub.jdk.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: SemaphoreTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月19日 上午8:55:45
 * @description: 控制并发线程数的Semaphore
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class SemaphoreTest {

	private static final int THREAD_COUNT = 5;

	private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

	private static Semaphore s = new Semaphore(10);

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					try {
						s.acquire();
						System.out.println("save data " + System.currentTimeMillis());
						s.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}

		threadPool.shutdown();
	}
}
