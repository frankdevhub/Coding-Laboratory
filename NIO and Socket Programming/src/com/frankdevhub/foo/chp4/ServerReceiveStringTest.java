package com.frankdevhub.foo.chp4;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: ServerReceiveStringTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月10日 下午10:13:02
 * @description: 客户端向服务端传递字符串
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class ServerReceiveStringTest {

	protected class ServerThread extends Thread {
		@Override
		public void run() {
			try {
				serverReceiveString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected class ClientThread extends Thread {
		@Override
		public void run() {
			try {
				clientPushString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void serverReceiveString() throws IOException {
		Socket socket = null;
		OutputStream outputStream = null;
		try {
			System.out.println("socket begin time=" + System.currentTimeMillis());
			socket = new Socket("localhost", 8090);
			System.out.println("socket end time=" + System.currentTimeMillis());

			outputStream = socket.getOutputStream();
			outputStream.write("this is a test message from client to server".getBytes());
			outputStream.flush();

			Thread.sleep(3000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			outputStream.close();
			socket.close();
		}
	}

	private void clientPushString() throws IOException {
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			char[] charArray = new char[1024];
			serverSocket = new ServerSocket(8090);
			System.out.println("server socket accept begin time=" + System.currentTimeMillis());
			socket = serverSocket.accept();
			System.out.println("server socket accept end time=" + System.currentTimeMillis());

			inputStream = socket.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			System.out.println("server socket read begin time=" + System.currentTimeMillis());
			int readLength = 0;

			readLength = inputStreamReader.read(charArray);
			while (readLength != -1) {
				String newString = new String(charArray, 0, readLength);
				System.out.println(newString);
				readLength = inputStreamReader.read(charArray);
			}
			System.out.println("server socket read end time=" + System.currentTimeMillis());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			inputStreamReader.close();
			inputStream.close();
			socket.close();
			serverSocket.close();
		}
	}

	public static void main(String[] args) {
		ServerReceiveStringTest test = new ServerReceiveStringTest();
		Thread threadA = test.new ServerThread();
		Thread threadB = test.new ClientThread();

		threadA.start();
		threadB.start();
	}
}
