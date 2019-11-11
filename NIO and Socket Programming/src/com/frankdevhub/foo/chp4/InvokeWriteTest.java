package com.frankdevhub.foo.chp4;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: InvokeWriteTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月11日 下午3:51:27
 * @description: 允许多次调用write()方法进行写入操作
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */

//Result

/*server accept begin time=1573469307825
client connect prepare set
client connect prepare done
server accept end time=1573469308065
server read begin time=1573469310069
 clie while 1573469310069
nt se while 1573469310070
nd a  while 1573469310070
messa while 1573469310070
ge[1] while 1573469310070
  while 1573469310070
 clie while 1573469313069
nt se while 1573469313069
nd a  while 1573469313069
messa while 1573469313069
ge[2] while 1573469313070
  while 1573469313070
 clie while 1573469316069
nt se while 1573469316069
nd a  while 1573469316070
messa while 1573469316070
ge[3] while 1573469316070
  while 1573469316070
 clie while 1573469319069
nt se while 1573469319069
nd a  while 1573469319069
messa while 1573469319070
ge[4] while 1573469319070
  while 1573469319070
 clie while 1573469322069
nt se while 1573469322070
nd a  while 1573469322070
messa while 1573469322070
ge[5] while 1573469322070
  while 1573469322070
server read end time=1573469325070
client close end time=1573469325069
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
			try {
				doClientPush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doClientPush() throws IOException {
		Socket socket = null;
		OutputStream outputStream = null;
		try {
			System.out.println("client connect prepare set");
			socket = new Socket("localhost", 8090);
			System.out.println("client connect prepare done");

			Thread.sleep(2000);
			outputStream = socket.getOutputStream();
			for (int i = 0; i < 5; i++) {
				outputStream.write((" client send a message[" + (i + 1) + "] ").getBytes());
				Thread.sleep(3000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			outputStream.flush();
			outputStream.close();
			socket.close();
			System.out.println("client close end time=" + System.currentTimeMillis());
		}
	}

	private void doServerReceive() throws IOException {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;

		char[] charBuffer = new char[5];
		try {
			serverSocket = new ServerSocket(8090);
			System.out.println("server accept begin time=" + System.currentTimeMillis());
			socket = serverSocket.accept();
			System.out.println("server accept end time=" + System.currentTimeMillis());

			inputStream = socket.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			int readLength = inputStreamReader.read(charBuffer);

			System.out.println("server read begin time=" + System.currentTimeMillis());
			while (readLength != -1) {
				System.out.print(new String(charBuffer, 0, readLength)
						+" while "+System.currentTimeMillis());
				readLength = inputStreamReader.read(charBuffer);
				System.out.println();
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
		try {
			InvokeWriteTest test = new InvokeWriteTest();
			Thread threadA = test.new ServerThread();
			Thread threadB = test.new ClientThread();

			threadA.start();
			Thread.sleep(200);
			threadB.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
