package com.frankdevhub.jdk.framework;

import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClassName: BankWorkService
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月18日 下午3:42:17
 * @description: CyclicBarrier的应用场景
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class BankWorkService implements Runnable {

	// 创建4个屏障，处理完之后执行当前的run方法
	private CyclicBarrier c = new CyclicBarrier(4, this);

	// 架设只有4个sheet，所以只启动4个线程
	private Executor executor = Executors.newFixedThreadPool(4);

	// 保存每个sheet计算出的银流结果
	private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>(4);

	private void count() {
		for (int i = 0; i < 4; i++) {
			executor.execute(new Runnable() {

				@Override
				public void run() {
					sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
					try {
						c.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	@Override
	public void run() {
		int result = 0;

		// 汇总每个sheet计算出的结果
		for (Entry<String, Integer> sheet : sheetBankWaterCount.entrySet())
			result += sheet.getValue();

		// 将结果输出
		sheetBankWaterCount.put("result", result);
		System.out.println("result=" + result);
	}

	public static void main(String[] args) {
		BankWorkService bankWorkService = new BankWorkService();
		bankWorkService.count();
	}
}
