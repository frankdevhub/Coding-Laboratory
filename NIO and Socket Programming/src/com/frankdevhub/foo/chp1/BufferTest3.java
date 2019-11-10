package com.frankdevhub.foo.chp1;

import java.nio.CharBuffer;

/**
 * @ClassName: BufferTest3
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月10日 下午1:39:24
 * @description: 位置获取与设置
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class BufferTest3 {
	// A capacity()=4 limit()=4 position=0
	// B capacity()=4 limit()=4 position=2
	// a b z d
	public static void main(String[] args) {
		char[] charArray = new char[] { 'a', 'b', 'c', 'd' };
		CharBuffer charBuffer = CharBuffer.wrap(charArray);
		System.out.println("A capacity()=" + charBuffer.capacity() + " limit()=" + charBuffer.limit() + " position="
				+ charBuffer.position());
		charBuffer.position(2);
		System.out.println("B capacity()=" + charBuffer.capacity() + " limit()=" + charBuffer.limit() + " position="
				+ charBuffer.position());

		charBuffer.put('z');
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i] + " ");
		}
	}
}
