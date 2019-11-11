package com.frankdevhub.foo.chp4;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: CSTransferTest
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月11日 下午7:01:13
 * @description: 实现服务端与客户端多次的往来通信
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class CSTransferTest {
	protected class ServerThread extends Thread {
		@Override
		public void run() {
			try {
				doServerBusiness();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected class ClientThread extends Thread {
		@Override
		public void run() {
			try {
				doClientBusiness();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doServerBusiness() throws IOException {
		System.out.println("do server business");
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		ObjectInputStream objectInputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			serverSocket = new ServerSocket(8090);
			socket = serverSocket.accept();

			// 输入开始
			inputStream = socket.getInputStream();
			objectInputStream = new ObjectInputStream(inputStream);
			int byteLength = objectInputStream.readInt();
			byte[] byteArray = new byte[byteLength];
			objectInputStream.readFully(byteArray);
			String newString = new String(byteArray);
			System.out.println(newString);
			// 输入结束

			// 输出开始
			outputStream = socket.getOutputStream();
			String strA = "client hello A\n";
			String strB = "client hello B\n";
			String strC = "client hello C\n";

			objectOutputStream = new ObjectOutputStream(outputStream);
			int allStrByteLength = (strA + strB + strC).getBytes().length;
			objectOutputStream.writeInt(allStrByteLength);
			objectOutputStream.flush();

			objectOutputStream.write(strA.getBytes());
			objectOutputStream.write(strB.getBytes());
			objectOutputStream.write(strC.getBytes());
			objectOutputStream.flush();
			// 输出结束

			// 输入开始
			byteLength = objectInputStream.readInt(); 
			//java.io.StreamCorruptedException: invalid type code: AC
			
			byteArray = new byte[byteLength];
			objectInputStream.readFully(byteArray);
			newString = new String(byteArray);
			System.out.println(newString);
			// 输入结束

			// 输出开始
			strA = "client hello D\n";
			strB = "client hello E\n";
			strC = "client hello F\n";

			objectOutputStream = new ObjectOutputStream(outputStream);
			allStrByteLength = (strA + strB + strC).getBytes().length;
			objectOutputStream.writeInt(allStrByteLength);
			objectOutputStream.flush();

			objectOutputStream.write(strA.getBytes());
			objectOutputStream.write(strB.getBytes());
			objectOutputStream.write(strC.getBytes());
			objectOutputStream.flush();
			// 输出结束
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
			outputStream.close();
			serverSocket.close();
			socket.close();
		}
	}

	private void doClientBusiness() throws IOException {
		System.out.println("do client business");
		Socket socket = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		ObjectInputStream objectInputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			socket = new Socket("localhost", 8090);

			// 输出开始
			outputStream = socket.getOutputStream();
			String strA = "server hello A\n";
			String strB = "server hello B\n";
			String strC = "server hello C\n";

			objectOutputStream = new ObjectOutputStream(outputStream);
			int allStrByteLength = (strA + strB + strC).getBytes().length;
			objectOutputStream.writeInt(allStrByteLength);
			objectOutputStream.flush();

			objectOutputStream.write(strA.getBytes());
			objectOutputStream.write(strB.getBytes());
			objectOutputStream.write(strC.getBytes());
			objectOutputStream.flush();
			// 输出结束

			// 输入开始
			inputStream = socket.getInputStream();
			objectInputStream = new ObjectInputStream(inputStream);
			int byteLength = objectInputStream.readInt();
			byte[] byteArray = new byte[byteLength];
			objectInputStream.readFully(byteArray);
			String newString = new String(byteArray);
			System.out.println(newString);
			// 输入结束

			// 输出开始
			strA = "server hello D\n";
			strB = "server hello E\n";
			strC = "server hello F\n";

			objectOutputStream = new ObjectOutputStream(outputStream);
			allStrByteLength = (strA + strB + strC).getBytes().length;
			objectOutputStream.writeInt(allStrByteLength);
			objectOutputStream.flush();

			objectOutputStream.write(strA.getBytes());
			objectOutputStream.write(strB.getBytes());
			objectOutputStream.write(strC.getBytes());
			objectOutputStream.flush();
			// 输出结束

			// 输入开始
			byteLength = objectInputStream.readInt();
			byteArray = new byte[byteLength];
			objectInputStream.readFully(byteArray);
			newString = new String(byteArray);
			System.out.println(newString);
			// 输入结束

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			outputStream.close();
			inputStream.close();
			socket.close();
		}
	}

	public static void main(String[] args) {

		CSTransferTest test = new CSTransferTest();
		ServerThread threadA = test.new ServerThread();
		ClientThread threadB = test.new ClientThread();

		threadA.start();
		threadB.start();

	}
}
