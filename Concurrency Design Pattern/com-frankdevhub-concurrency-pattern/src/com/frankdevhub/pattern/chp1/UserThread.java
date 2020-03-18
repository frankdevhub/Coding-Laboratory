package com.frankdevhub.pattern.chp1;

import java.util.Random;

public class UserThread extends Thread {
	private final static Random random = new Random(26235);
	private final BoundedResource resource;

	public UserThread(BoundedResource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		super.run();
		try {
			while (true) {
				resource.use();
				Thread.sleep(random.nextInt(3000));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		BoundedResource resource = new BoundedResource(3);
		for (int i = 0; i < 10; i++) {
			new UserThread(resource).start();
		}
	}
}
