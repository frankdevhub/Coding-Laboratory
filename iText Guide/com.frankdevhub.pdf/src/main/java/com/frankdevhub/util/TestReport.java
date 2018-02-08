package com.frankdevhub.util;

import java.util.Date;

import org.apache.log4j.Logger;

//fangchensheng start 2017/12/31 测试报告类用于注入freemarker模板
public class TestReport {
	private String userName;
	private String password;
	private Date modifyDate;

	private static final Logger LOGGER = Logger.getLogger(TestReport.class);

	public TestReport() {
		super();
	}

	public TestReport(String userName, String password, Date modifyDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.modifyDate = modifyDate;
	}

	public String getUserName() {
		LOGGER.debug("GET REPORT USERNAME:" + userName);
		return userName;
	}

	public void setUserName(String userName) {
		LOGGER.debug("SET REPORT USERNAME:" + userName);
		this.userName = userName;
	}

	public String getPassword() {
		LOGGER.debug("GET REPORT PASSWORD:" + password);
		return password;
	}

	public void setPassword(String password) {
		LOGGER.debug("SET REPORT PASSWORD:" + password);
		this.password = password;
	}

	public Date getModifyDate() {
		LOGGER.debug("GET REPORT MODIFY DATE:" + modifyDate);
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		LOGGER.debug("SET REPORT MODIFY DATE:" + modifyDate);
		this.modifyDate = modifyDate;
	}

}
