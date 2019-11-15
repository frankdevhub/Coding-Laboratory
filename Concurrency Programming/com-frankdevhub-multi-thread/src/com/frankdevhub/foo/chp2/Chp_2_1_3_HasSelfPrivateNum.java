package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_3_HasSelfPrivateNum
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月5日 上午9:04:02
 * @description: 多个对象多个锁
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_3_HasSelfPrivateNum {
	private int num = 0;

	synchronized public void addI(String username) {
		try {
			if (username.equals("a")) {
				num = 100;
				System.out.println("a set over!");
				Thread.sleep(2000);
			} else {
				num = 200;
				System.out.println("b set over!");
			}
			System.out.println(username + " num=" + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
