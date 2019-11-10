package com.frankdevhub.foo.chp4;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: ClientReceiveStringTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月10日 下午10:48:15
 * @description: 服务端向客户端传递字符串
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class ClientReceiveStringTest {

	protected class ServerThread extends Thread {
		@Override
		public void run() {
			try {
				serverPushString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected class ClientThread extends Thread {
		@Override
		public void run() {
			try {
				clientReceiveString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void serverPushString() throws IOException {
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream outputStream = null;
		try {
			serverSocket = new ServerSocket(8090);
			System.out.println("server accept start time=" + System.currentTimeMillis());
			socket = serverSocket.accept();
			System.out.println("server accept end time=" + System.currentTimeMillis());

			outputStream = socket.getOutputStream();
			outputStream.write("this is a test message from server".getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outputStream.flush();
			outputStream.close();
			socket.close();
			serverSocket.close();
		}
	}

	private void clientReceiveString() throws IOException {
		Socket socket = null;
		InputStream inputStream = null;
		try {
			System.out.println("client start time=" + System.currentTimeMillis());
			socket = new Socket("localhost", 8090);
			System.out.println("client start end=" + System.currentTimeMillis());

			char[] charBuffer = new char[3];
			inputStream = socket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			System.out.println("client read start time=" + System.currentTimeMillis());
			int readLength = inputStreamReader.read(charBuffer);
			while (readLength != -1) {
				System.out.print(new String(charBuffer, 0, readLength));
				readLength = inputStreamReader.read(charBuffer);
			}

			System.out.println("client read end time=" + System.currentTimeMillis());
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
			socket.close();
		}
	}

	// client start time=1573398447490
	// server accept start time=1573398447498
	// client start end=1573398447513
	// server accept end time=1573398447513
	// client read start time=1573398447514
	// this is a test message from serverclient read end time=1573398447515
	public static void main(String[] args) {
		ClientReceiveStringTest test = new ClientReceiveStringTest();
		Thread threadA = test.new ServerThread();
		Thread threadB = test.new ClientThread();

		threadA.start();
		threadB.start();

	}
}
