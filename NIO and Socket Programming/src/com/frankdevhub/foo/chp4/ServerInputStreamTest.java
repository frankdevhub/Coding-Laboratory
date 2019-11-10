package com.frankdevhub.foo.chp4;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: ServerInputStream
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月10日 下午9:17:09
 * @description: 验证Server中InpoutStream类的read()方法也具有阻塞特性
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class ServerInputStreamTest {

	protected class InitServerThread extends Thread {
		@Override
		public void run() {
			try {
				initServer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected class InitClientThread extends Thread {
		@Override
		public void run() {
			try {
				initClient();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void initServer() throws IOException {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream inputStream = null;
		try {
			byte[] byteArray = new byte[1024];
			serverSocket = new ServerSocket(8090);

			System.out.println("server socket accept begin=" + System.currentTimeMillis());
			socket = serverSocket.accept(); // 呈阻塞效果
			System.out.println("server socket accept end=" + System.currentTimeMillis());

			inputStream = socket.getInputStream();
			System.out.println("server socket inputstream read start=" + System.currentTimeMillis());
			@SuppressWarnings("unused")
			int readLength = inputStream.read(byteArray); // 呈阻塞效果
			System.out.println("server socket inputstream read end=" + System.currentTimeMillis());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
			socket.close();
			serverSocket.close();
		}
	}

	private void initClient() throws IOException {
		Socket socket = null;
		try {
			System.out.println("socket begin time=" + System.currentTimeMillis());
			socket = new Socket("localhost", 8090);
			System.out.println("socket end time=" + System.currentTimeMillis());
			Thread.sleep(Integer.MAX_VALUE);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}

	}

	// server socket accept begin=1573393108540
	// socket begin time=1573393110529
	// server socket accept end=1573393110550
	// server socket inputstream read start=1573393110550
	// socket end time=1573393110551

	public static void main(String[] args) throws IOException {
		ServerInputStreamTest test = new ServerInputStreamTest();
		Thread threadA = test.new InitServerThread();
		Thread threadB = test.new InitClientThread();
		try {

			threadA.start();
			Thread.sleep(2000);
			threadB.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
