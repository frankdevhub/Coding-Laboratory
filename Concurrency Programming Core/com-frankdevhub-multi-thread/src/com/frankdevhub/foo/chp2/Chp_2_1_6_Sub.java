package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_6_Sub
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月7日 下午10:30:17
 * @description: 子类通过可重入锁调用父类方法
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_6_Sub extends Chp_2_1_6_Main {

	public synchronized void operateISubMethod() {
		while (i > 0) {
			try {
				i--;
				System.out.println(Thread.currentThread().getName() + " Sub print i=" + i);
				Thread.sleep(100);
				this.operateIMainMethod(); // 当存在父子关系继承时，子类可以通过可重入锁调用父类的同步方法
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
