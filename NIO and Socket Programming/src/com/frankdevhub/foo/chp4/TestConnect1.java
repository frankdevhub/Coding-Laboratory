package com.frankdevhub.foo.chp4;

import java.io.IOException;
import java.net.Socket;

/**
 * @ClassName: TestConnect1
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月10日 下午8:42:26
 * @description: 测试客户端和服务端的连接(可连接情况下)
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class TestConnect1 {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("www.baidu.com", 80);
			System.out.println("client connect success");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("client connect fail");
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
