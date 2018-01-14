package com.base.test;

public class BizTest {
	public static void main(String[] args) {
		BaseService baseService = new BaseService();
		TestService1 testService1 = new TestService1(baseService);
		testService1.setName("test1");
		TestService2 testService2 = new TestService2(baseService);
		testService2.setName("test2");
		// fangchensheng start 2018/1/14 猜测和观察先后关系对启动的影响
		testService1.run();
		testService2.run();
	}
}
