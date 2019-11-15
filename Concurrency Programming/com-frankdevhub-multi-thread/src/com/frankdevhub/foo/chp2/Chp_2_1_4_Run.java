package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_4_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月5日 下午9:30:03
 * @description: synchronized方法锁与对象
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_4_Run {

	// Object类中添加同步关键字时
	// method begin threadName=A
	// end
	// method begin threadName=B
	// end

	// Object类中无同步方法时
	// method begin threadName=A
	// method begin threadName=B
	// end
	// end

	public static void main(String[] args) {

		Chp_2_1_4_MyObject object = new Chp_2_1_4_MyObject();
		Chp_2_1_4_ThreadA threadA = new Chp_2_1_4_ThreadA(object);
		threadA.setName("A");
		Chp_2_1_4_ThreadB threadB = new Chp_2_1_4_ThreadB(object);
		threadB.setName("B");

		threadA.start();
		threadB.start();

	}
}
