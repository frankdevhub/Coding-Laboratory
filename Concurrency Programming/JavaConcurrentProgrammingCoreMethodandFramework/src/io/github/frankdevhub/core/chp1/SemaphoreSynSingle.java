package io.github.frankdevhub.core.chp1;

import java.util.concurrent.Semaphore;

/**   
* Copyright: Copyright (c) 2018 fangchensheng
* 
* @ClassName: a.java
* @Description: 
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年2月9日 下午7:07:16 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年2月9日     Administrator           v1.0.0        /
*/
public class SemaphoreSynSingle {
	static class SemaphoreService implements Runnable{
        private Semaphore sph = new Semaphore(1); 
		@Override
		public void run() {
 			try {
 				//请求资源
				sph.acquire();
				Long mark = System.currentTimeMillis();
				System.out.println("Current Thread begin:\t"+mark);
				Thread.sleep(3000);
				sph.release();
				System.out.println("Currernt Thread end:\t"+mark);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			
		}
         
		
	}
	
	public static void main(String[] args) {
		SemaphoreService service = new SemaphoreService();
		Thread testThread1 = new Thread(service);
		Thread testThread2 = new Thread(service);
		testThread1.run();
		testThread2.run();
	}
}
