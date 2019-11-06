package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_5_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月6日 下午10:02:47
 * @description: 脏读
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_5_Run {

	// getValue method name=main username=B password=AA
	// setValue method name=Thread-0 username=B password=BB

	public static void main(String[] args) {
		Chp_2_1_5_PublicVar publicVarRef = new Chp_2_1_5_PublicVar();
		try {
			Chp_2_1_5_ThreadA threadA = new Chp_2_1_5_ThreadA(publicVarRef);
			threadA.start();
			Thread.sleep(200); // 打印结果受此值的大小影响

			publicVarRef.getValue();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
