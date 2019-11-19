package com.frankdevhub.jdk.framework;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ExchangerTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月19日 下午10:05:03
 * @description: 线程间交换数据的Exchanger
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class ExchangerTest {

	private static final Exchanger<String> exgr = new Exchanger<String>();

	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String recordA = "record";
					exgr.exchange(recordA);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				try {
					String recordB = "record";
					String recordA = exgr.exchange("recordB");
					if (recordA.equals(recordB)) {
						System.out.println("A equals B");
					} else {
						System.out.println("A not equals B");
					}
					System.out.println("A=" + recordA + " B=" + recordB + "");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		threadPool.shutdown();
	}
}
