package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_8_Run1
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月15日 上午2:06:47
 * @description:
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_8_Run1 {

	protected class ThreadA extends Thread {
		private Chp_2_1_8_Task task;

		public ThreadA(Chp_2_1_8_Task task) {
			super();
			this.task = task;
		}

		@Override
		public void run() {
			Chp_2_1_8_CommonUtils.beginTime1 = System.currentTimeMillis();
			task.doLongTask();
			Chp_2_1_8_CommonUtils.endTime1 = System.currentTimeMillis();
		}
	}

	protected class ThreadB extends Thread {
		private Chp_2_1_8_Task task;

		public ThreadB(Chp_2_1_8_Task task) {
			super();
			this.task = task;
		}

		@Override
		public void run() {
			Chp_2_1_8_CommonUtils.beginTime2 = System.currentTimeMillis();
			task.doLongTask();
			Chp_2_1_8_CommonUtils.endTime2 = System.currentTimeMillis();
		}
	}

	public static void main(String[] args) {
		try {
			Chp_2_1_8_Run1 run = new Chp_2_1_8_Run1();
			Chp_2_1_8_Task task = new Chp_2_1_8_Task();

			Thread threadA = run.new ThreadA(task);
			Thread threadB = run.new ThreadB(task);
			threadA.start();
			threadB.start();

			Thread.sleep(10000);

			long beginTime = Chp_2_1_8_CommonUtils.beginTime1;
			if (Chp_2_1_8_CommonUtils.beginTime1 > Chp_2_1_8_CommonUtils.beginTime2)
				beginTime = Chp_2_1_8_CommonUtils.beginTime2;
			long endTime = Chp_2_1_8_CommonUtils.endTime1;
			if (Chp_2_1_8_CommonUtils.endTime1 < Chp_2_1_8_CommonUtils.endTime2)
				endTime = Chp_2_1_8_CommonUtils.endTime2;

			long costTime = endTime - beginTime;

			System.out.println("cost time: " + costTime / 1000 + " sec");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
