package com.frankdevhub.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lowagie.tools.BuildTutorial;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import junit.framework.Assert;

//fangchensheng start 2017/12/31 文本生成器
public class TestReportBuilder {
	private static final String REPORT = "report";
	private String templateFileName;
	private File templateDirectory;
	private TestReport data;

	private static final Logger LOGGER = Logger.getLogger(TestReportBuilder.class);

	public static TestReportBuilder newReport() {
		return new TestReportBuilder();
	}

	public TestReportBuilder setData(TestReport data) {
		this.data = data;
		return this;
	}

	public TestReportBuilder setTemplateDirectoryPath(String path) throws Exception {
		this.templateDirectory = new File(path);
		if (Boolean.FALSE.equals(templateDirectory.isDirectory()))
			throw new Exception("template directory should be a directory!");
		return this;
	}

	public TestReportBuilder setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
		return this;
	}

	public ByteArrayOutputStream build() throws IOException {
		String loadHtml = this.loadHtml();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		PDFUtil.saveChinesePdf(bos, loadHtml);
		return bos;
	}

	private String loadHtml() {

		// version:2.3.23
		Configuration config = new Configuration(Configuration.VERSION_2_3_23);
		try {
			config.setDirectoryForTemplateLoading(this.templateDirectory);
			config.setDefaultEncoding("UTF-8");
			config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			config.setClassicCompatible(true);

			// get template
			Template template = config.getTemplate(this.templateFileName);
			StringWriter writer = new StringWriter();
			// inject Data Map
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put(REPORT, data);
			template.process(dataMap, writer);

			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("load fail file");

		}
	}

}
