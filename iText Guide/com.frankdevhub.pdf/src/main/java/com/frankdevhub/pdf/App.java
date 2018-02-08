package com.frankdevhub.pdf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.frankdevhub.util.PDFService;
import com.frankdevhub.util.PDFUtil;
import com.frankdevhub.util.TestReport;

// fangchensheng start PDF tool 2017/12/31
public class App {
	private static final Logger LOGGER = Logger.getLogger(App.class);
	private static final String templateDirectoryPath = "src/main/resources/templates";
	private static final String templateName = "reportsTmp.ftl";
	private static final String pdfPath = "D://";
	private static final String pdfName = "user.pdf";

	public static void main(String[] args) throws Exception {
		LOGGER.info("start");
		TestReport testReport = new TestReport();
		testReport.setModifyDate(new Date());
		testReport.setPassword(UUID.randomUUID().toString());
		testReport.setUserName("frankdevhub");
		OutputStream os = PDFService.instance().generatePDF(testReport, templateDirectoryPath, templateName);
		FileOutputStream fos = new FileOutputStream(new File(pdfPath + pdfName));
		InputStream is = PDFUtil.parse(os);
		BufferedInputStream bis = new BufferedInputStream(is);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] b = new byte[2048];
		int len;
		while ((len = bis.read(b)) != -1)
			bos.write(b, 0, len);
	}
}
