package com.frankdevhub.pattern.chp1;

/**
 * @ClassName: Test
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月4日 下午6:33:29
 * @description: 不使用Single Threaded Execution模式的程序
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class UnSafeGate {
	private int counter = 0;
	private String name = "Nobody";
	private String address = "Nowhere";

	public void pass(String name, String address) {
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

	public String toString() {
		return "No." + counter + ": " + name + ", " + address;
	}
}
