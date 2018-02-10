package io.github.frankdevhub.mail;

import java.io.File;
import java.util.Properties;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/**
 * @author fangchensheng
 *
 */
public interface AbstractMailSender {

	public Properties configDefault();

	public Properties configSMTP(String hostName);

	public Boolean byAuthenticator(String userName, String password);

	public AbstractMailSender setSubject(String subject, String nickName);

	public AbstractMailSender setMailFrom(String to, String nickName);

	public AbstractMailSender setMailTo(String to, String nickName);

	public AbstractMailSender setMailTo();

	public AbstractMailSender setReplyTo(String reply);

	public AbstractMailSender setReplyTo(String... replies);

	public AbstractMailSender setCC(String cc);

	public AbstractMailSender setCC(String... ccs);

	public AbstractMailSender setByCC(String bcc);

	public AbstractMailSender setByCC(String... bccs);

	public MimeBodyPart attachDocument(File attachment, String fileName);

	public MimeBodyPart setMimeMultipartToBody(MimeMultipart multiPart, MimeBodyPart bodyPart);

	public Boolean send();
}
