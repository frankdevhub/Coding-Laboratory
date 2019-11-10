package com.frankdevhub.foo.chp1;

import java.nio.CharBuffer;

/**
 * @ClassName: BufferTest4
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月10日 下午1:46:02
 * @description: 剩余大小获取
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class BufferTest4 {
	// A capacity()=5 limit()=5 position=0
	// B capacity()=5 limit()=5 position=2
	// C remaining()=3

	public static void main(String[] args) {
		char[] charArray = new char[] { 'a', 'b', 'c', 'd', 'e' };
		CharBuffer charBuffer = CharBuffer.wrap(charArray);
		System.out.println("A capacity()=" + charBuffer.capacity() + " limit()=" + charBuffer.limit() + " position="
				+ charBuffer.position());
		charBuffer.position(2);
		System.out.println("B capacity()=" + charBuffer.capacity() + " limit()=" + charBuffer.limit() + " position="
				+ charBuffer.position());

		System.out.println("C remaining()=" + charBuffer.remaining());
	}
}
