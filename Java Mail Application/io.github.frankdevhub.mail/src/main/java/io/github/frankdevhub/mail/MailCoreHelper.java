package io.github.frankdevhub.mail;

import java.io.File;
import java.util.Properties;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/**
 * @author Administrator
 *
 */
public class MailCoreHelper implements AbstractMailSender {

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.github.frankdevhub.mail.AbstractMailSender#configDefault()
	 */
	public Properties configDefault() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.github.frankdevhub.mail.AbstractMailSender#configSMTP(java.lang.
	 * String)
	 */
	public Properties configSMTP(String hostName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.frankdevhub.mail.AbstractMailSender#byAuthenticator(java.lang.
	 * String, java.lang.String)
	 */
	public Boolean byAuthenticator(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.github.frankdevhub.mail.AbstractMailSender#setSubject(java.lang.
	 * String, java.lang.String)
	 */
	public AbstractMailSender setSubject(String subject, String nickName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.github.frankdevhub.mail.AbstractMailSender#setMailFrom(java.lang.
	 * String, java.lang.String)
	 */
	public AbstractMailSender setMailFrom(String to, String nickName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.frankdevhub.mail.AbstractMailSender#setMailTo(java.lang.String,
	 * java.lang.String)
	 */
	public AbstractMailSender setMailTo(String to, String nickName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.github.frankdevhub.mail.AbstractMailSender#setMailTo()
	 */
	public AbstractMailSender setMailTo() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.github.frankdevhub.mail.AbstractMailSender#setReplyTo(java.lang.
	 * String)
	 */
	public AbstractMailSender setReplyTo(String reply) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.frankdevhub.mail.AbstractMailSender#setReplyTo(java.lang.String
	 * [])
	 */
	public AbstractMailSender setReplyTo(String... replies) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.frankdevhub.mail.AbstractMailSender#setCC(java.lang.String)
	 */
	public AbstractMailSender setCC(String cc) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.frankdevhub.mail.AbstractMailSender#setCC(java.lang.String[])
	 */
	public AbstractMailSender setCC(String... ccs) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.frankdevhub.mail.AbstractMailSender#setByCC(java.lang.String)
	 */
	public AbstractMailSender setByCC(String bcc) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.frankdevhub.mail.AbstractMailSender#setByCC(java.lang.String[])
	 */
	public AbstractMailSender setByCC(String... bccs) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.frankdevhub.mail.AbstractMailSender#attachDocument(java.io.
	 * File, java.lang.String)
	 */
	public MimeBodyPart attachDocument(File attachment, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.frankdevhub.mail.AbstractMailSender#setMimeMultipartToBody(
	 * javax.mail.internet.MimeMultipart, javax.mail.internet.MimeBodyPart)
	 */
	public MimeBodyPart setMimeMultipartToBody(MimeMultipart multiPart, MimeBodyPart bodyPart) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.github.frankdevhub.mail.AbstractMailSender#send()
	 */
	public Boolean send() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Copyright: Copyright (c) 2018 fangchensheng
	 * 
	 * @ClassName: MailCoreHelper.java
	 * @Description:
	 *
	 * @version: v1.0.0
	 * @author: Administrator
	 * @date: 2018年2月9日 下午7:07:16
	 *
	 *        Modification History: Date Author Version Description
	 *        --------------------------------------------------------------*
	 *        2018年2月9日 Administrator v1.0.0 创建
	 */
}
