package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_5_PublicVar
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月6日 下午9:50:06
 * @description: 脏读
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_5_PublicVar {

	public String username = "A";
	public String password = "AA";

	synchronized public void setValue(String username, String password) {
		try {
			this.username = username;
			Thread.sleep(5000);
			this.password = password;
			System.out.println("setValue method name=" + Thread.currentThread().getName() + " username=" + username
					+ " password=" + password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 如果synchronized关键字不加会出现脏读
	public void getValue() {
		System.out.println("getValue method name=" + Thread.currentThread().getName() + " username=" + username
				+ " password=" + password);
	}

}
