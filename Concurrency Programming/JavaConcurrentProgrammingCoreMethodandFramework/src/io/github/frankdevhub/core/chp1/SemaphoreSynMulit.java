package io.github.frankdevhub.core.chp1;

import java.util.concurrent.Semaphore;

/**
 * @author Administrator
 *
 */
public class SemaphoreSynMulit {
	/**
	 * Copyright: Copyright (c) 2018 fangchensheng
	 * 
	 * @ClassName: SemaphoreSynMulit.java
	 * @Description: 该类的功能描述
	 *
	 * @version: v1.0.0
	 * @author: Administrator
	 * @date: 2018年2月9日 下午7:07:16
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2018年2月9日 Administrator v1.0.0
	 */

	protected class SharedResource {
		protected Semaphore sph = new Semaphore(1);
	}

	protected class AbstractThread extends Thread {

		protected SharedResource resource;

		protected AbstractThread(SharedResource resource) {
			this.resource = resource;
		}

		/**
		 * @return the resource
		 */
		public SharedResource getResource() {
			return resource;
		}

		@Override
		public void run() {
			try {
				Long mark = System.currentTimeMillis();
				resource.sph.acquire(1);
				System.out.println("Current Thread begin:\t" + mark);
				Thread.sleep(1000);
				resource.sph.release(1);
				System.out.println("Current Thread end:\t" + mark);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		SemaphoreSynMulit synMulti =new SemaphoreSynMulit();
		SharedResource resource = synMulti.new SharedResource();
		SemaphoreSynMulit.AbstractThread testThread1 = synMulti.new AbstractThread(resource);
		SemaphoreSynMulit.AbstractThread testThread2 = synMulti.new AbstractThread(resource);
		SemaphoreSynMulit.AbstractThread testThread3 = synMulti.new AbstractThread(resource);
		testThread1.start();
		testThread2.start();
		testThread3.start();
	}
}
