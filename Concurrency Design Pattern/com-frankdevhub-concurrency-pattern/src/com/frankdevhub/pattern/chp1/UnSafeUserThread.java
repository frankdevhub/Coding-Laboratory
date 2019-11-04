package com.frankdevhub.pattern.chp1;

/**
 * @ClassName: UnSafeUserThread
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 下午10:07:32
 * @description: 不使用Single Threaded Execution模式的程序
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class UnSafeUserThread extends Thread {

	private final UnSafeGate gate;
	private final String myname;
	private final String address;

	public UnSafeUserThread(UnSafeGate gate, String myname, String address) {
		this.gate = gate;
		this.myname = myname;
		this.address = address;
	}

	@Override
	public void run() {
		System.out.println(myname + " BEGIN");
		while (true) {
			gate.pass(myname, address);
		}
	}
}
