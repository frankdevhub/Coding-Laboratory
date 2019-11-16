package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_2_HasSelfPrivateNum
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月3日 下午10:59:11
 * @description: 实例变量非线程安全
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_2_HasSelfPrivateNum {

	private int num = 0;

	public void addI(String userName) {
		try {
			if (userName.equals("a")) {
				num = 100;
				System.out.println("a set over!");
				Thread.sleep(2000);
			} else {
				num = 200;
				System.out.println("b set over!");
			}
			System.out.println(userName + "\t" + "num=" + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
