package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_6_MyThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月7日 下午9:59:27
 * @description: synchronized锁重入
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_6_MyThread extends Thread {

	@Override
	public void run() {
		Chp_2_1_6_Service service = new Chp_2_1_6_Service();
		service.service1();
	}
}
