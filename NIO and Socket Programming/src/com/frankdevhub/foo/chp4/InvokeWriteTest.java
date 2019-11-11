package com.frankdevhub.foo.chp4;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: InvokeWriteTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月11日 下午3:51:27
 * @description: 允许多次调用write()方法进行写入操作
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class InvokeWriteTest {

	protected class ServerThread extends Thread {
		@Override
		public void run() {
			try {
				doServerReceive();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected class ClientThread extends Thread {
		@Override
		public void run() {
			doClientPush();
		}
	}

	private void doClientPush() {
		try {
			System.out.println("client connect prepare set");
			
			System.out.println();
		} catch (IOException e) {

		}
	}

	private void doServerReceive() throws IOException {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream inputStream = null;
		InputStreamReader reader = null;

		char[] charBuffer = new char[5];
		try {
			serverSocket = new ServerSocket(8090);
			System.out.println("server accept begin time=" + System.currentTimeMillis());
			socket = serverSocket.accept();
			System.out.println("server accept end time=" + System.currentTimeMillis());

			inputStream = socket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			int readLength = inputStreamReader.read(charBuffer);

			System.out.println("server read begin time=" + System.currentTimeMillis());
			while (readLength != -1) {
				System.out.println(new String(charBuffer, 0, readLength)
						+" while "+System.currentTimeMillis());
				readLength = inputStreamReader.read(charBuffer);
			}
			
			System.out.println("server read end time=" + System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
			socket.close();
			serverSocket.close();
		}
	}

	public static void main(String[] args) {

	}
}
