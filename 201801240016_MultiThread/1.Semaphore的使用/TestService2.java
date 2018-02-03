package com.base.test;

//fangchensheng start 2018/1/14
public class TestService2 extends Thread {

	private BaseService baseService;

	public TestService2(BaseService baseService) {
		super();
		this.baseService = baseService;
	}

	public TestService2() {
		super();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			baseService.testMethod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
