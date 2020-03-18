package com.frankdevhub.pattern.chp1;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BoundedResource {
	private final Semaphore semaphore;
	private final int permits;
	private final static Random random = new Random(3141159);

	public BoundedResource(int permits) {
		this.permits = permits;
		this.semaphore = new Semaphore(permits);
	}

	public void use() throws InterruptedException {
		semaphore.acquire();
		try {
			doUse();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	protected void doUse() throws InterruptedException {
		Log.println("BEGIN: used = " + (permits - semaphore.availablePermits()));
		Thread.sleep(random.nextInt(500));
		Log.println("END: used = " + (permits - semaphore.availablePermits()));
	}
}
