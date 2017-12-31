package com.frankdevhub.util;

import java.io.OutputStream;

//fangchensheng start 2017/12/31 pdf服务
public class PDFService {
	private static PDFService service;

	private PDFService() {
	}

	public static PDFService instance() {
		if (service == null)
			return new PDFService();
		return service;
	}

	public OutputStream generatePDF(TestReport source, String templateDirectoryPath, String templateName)
			throws Exception {
		TestReportBuilder builder = TestReportBuilder.newReport().setTemplateDirectoryPath(templateDirectoryPath)
				.setTemplateFileName(templateName).setData(source);
		return builder.build();
	}

}
