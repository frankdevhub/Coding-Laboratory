package com.frankdevhub.pattern.chp1;

public class Log {
	public static void println(String s) {
		System.out.println(Thread.currentThread().getName() + ":" + s);
	}
}
