package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_3_4_VolatileThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月16日 下午1:55:06
 * @description: volatile非原子的特性
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_3_4_VolatileThread extends Thread {
	volatile public static int count;

	//加上static关键字
	//这样是对Chp_2_3_4_VolatileThread.class进行加锁
	//从而实现了同步效果
	
/*	synchronized private static void addCount() {
		for (int i = 0; i < 100; i++) {
			count++;
		}
		System.out.println("count=" + count);
	}
*/
	
	
	private void addCount() {
		for (int i = 0; i < 100; i++) {
			count++;
		}
		System.out.println("count=" + count);
	}

	@Override
	public void run() {
		addCount();
	}

}
