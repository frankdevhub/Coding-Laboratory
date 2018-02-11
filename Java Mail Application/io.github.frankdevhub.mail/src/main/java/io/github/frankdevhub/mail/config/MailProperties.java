package io.github.frankdevhub.mail.config;

import java.util.Properties;

/**
 * @author fangchensheng
 *
 */
public class MailProperties extends Properties {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see java.util.Hashtable#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public synchronized MailProperties put(Object key, Object value) {
		// TODO Auto-generated method stub
		 super.put(key, value);
		 return this;
	}
	/**   
	* Copyright: Copyright (c) 2018 fangchensheng
	* 
	* @ClassName: MailProperties.java
	* @Description: 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018年2月9日 下午7:07:16 
	*
	* Modification History:
	* Date         Author          Version            Description
	*--------------------------------------------------------------*
	* 2018年2月9日     Administrator           v1.0.0      邮件配置
	*/
	
}
