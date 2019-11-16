package com.frankdevhub.foo.chp2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName: Chp_2_3_6_AtomicIntegerService
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月16日 下午5:57:02
 * @description: 原子类也并不完全安全:方法与方法之间的调用有可能顺序错误
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */

public class Chp_2_3_6_AtomicIntegerService {
	// 此处如果修改为
	// static AtomicLong aiRef = new AtomicLong(0L);
	// 可以保持原子性和方法调用均保持有序输出

	public static AtomicLong aiRef = new AtomicLong(0L);

	public long getValue() {
		return aiRef.get();
	}

	synchronized public void addNum() {
		System.out.println(
				"threadName=" + Thread.currentThread().getName() 
				+ " add 100 return value=" + aiRef.addAndGet(100));

		aiRef.addAndGet(1);
	}
}
