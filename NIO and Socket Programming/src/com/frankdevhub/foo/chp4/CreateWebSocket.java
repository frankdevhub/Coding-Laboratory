package com.frankdevhub.foo.chp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: CreateWebSocket
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月10日 下午8:47:18
 * @description: 使用ServerSocket创建一个Web服务器
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */

//server start receive
//GET / HTTP/1.1
//Host: 127.0.0.1:8070
//Connection: keep-alive
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
//Accept-Encoding: gzip, deflate, br
//Accept-Language: zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7
//Cookie: Hm_lvt_4cbcf4f20c00cf6768989d0f363af2b8=1572964485,1572967432,1573115794,1573313091


public class CreateWebSocket {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			serverSocket = new ServerSocket(8070);
			socket = serverSocket.accept();
			inputStream = socket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);

			String getString = "";
			System.out.println("server start receive");
			while ("" != (getString = reader.readLine())) {
				System.out.println(getString);
			}
			System.out.println("server receive complete");

			outputStream = socket.getOutputStream();
			outputStream.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
			outputStream.write(("<html><body>"
					+ "<a href='http://www.baidu.com'>"
					+ "baidu link"
					+ "</a></body></html>").getBytes());
			
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
			outputStream.close();
			socket.close();
			serverSocket.close();
		}

	}
}
