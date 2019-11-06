package com.frankdevhub.foo.chp3;

/**
 * @ClassName: Chp_3_1_1_ThreadB
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月6日 上午9:03:40
 * @description: 不使用等待/通知机制实现线程间通信
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_3_1_1_ThreadB extends Thread {

	private Chp_3_1_1_MyList list;

	public Chp_3_1_1_ThreadB(Chp_3_1_1_MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		try {
			while (true) {
				if (list.getSize() == 5) {
					System.out.println("thread b start to terminate");
					throw new InterruptedException();
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); //事实是线程不能手动抛出异常此处会造成死循环
		}
	}
}
