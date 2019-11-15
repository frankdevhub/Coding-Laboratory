package com.frankdevhub.foo.chp2;

/**
 * @ClassName: Chp_2_1_8_Run
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月15日 上午12:38:57
 * @description: 同步不具有继承性
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class Chp_2_1_8_Run {

	protected class ThreadA extends Thread {
		private Chp_2_1_8_Sub sub;

		protected ThreadA(Chp_2_1_8_Sub sub) {
			this.sub = sub;
		}

		@Override
		public void run() {
			sub.serviceMethod();
		}
	}

	protected class ThreadB extends Thread {
		private Chp_2_1_8_Sub sub;

		protected ThreadB(Chp_2_1_8_Sub sub) {
			this.sub = sub;
		}

		@Override
		public void run() {
			sub.serviceMethod();
		}
	}

	// 父类方法同步，但是子类方法不同步，不具备继承性
	// int sub next sleep begin threadName=Thread-0 time=1573749856965
	// int sub next sleep begin threadName=Thread-1 time=1573749856965
	// int sub next sleep end threadName=Thread-1 time=1573749861967
	// int sub next sleep end threadName=Thread-0 time=1573749861967
	// int main next sleep begin threadName=Thread-0 time=1573749861967
	// int main next sleep end threadName=Thread-0 time=1573749866967
	// int main next sleep begin threadName=Thread-1 time=1573749866968
	// int main next sleep end threadName=Thread-1 time=1573749871968

	public static void main(String[] args) {
		Chp_2_1_8_Sub sub = new Chp_2_1_8_Sub();
		Chp_2_1_8_Run run = new Chp_2_1_8_Run();

		Thread threadA = run.new ThreadA(sub);
		Thread threadB = run.new ThreadB(sub);
		threadA.start();
		threadB.start();
	}
}
