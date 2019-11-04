package com.frankdevhub.pattern.chp1;

/**
 * @ClassName: SafeGate
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 下午10:44:35
 * @description:使用Single Threaded Execution模式的程序
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class SafeGate {
	private int counter = 0;
	private String name = "Nobody";
	private String address = "Nowhere";

	public synchronized void pass(String name, String address) {
		this.counter++;
		this.name = name;
		this.address = address;
		check();
	}

	private void check() {
		if (name.charAt(0) != address.charAt(0)) {
			System.out.println("****** BROKEN ****** " + toString());
		}
	}

	public synchronized String toString() {
		return "No." + counter + ": " + name + ", " + address;
	}
}
