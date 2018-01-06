package com.frankdevhub.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

//fangchensheng start 2017/12/31
public class PDFUtil {

	private static final Logger LOGGER = Logger.getLogger(PDFUtil.class);

	public static ByteArrayInputStream parse(OutputStream out) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos = (ByteArrayOutputStream) out;
		ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
		return swapStream;
	}

	public static void saveChinesePdf(ByteArrayOutputStream bos, String loadHtml) throws IOException {
		Document document = new Document(PageSize.A4, 50, 50, 60, 60);
		try {
			PdfWriter writer = PdfWriter.getInstance(document, bos);
			document.open();
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(loadHtml.getBytes()),
					Charset.forName("UTF-8"), new AsianFontProvider());

		} catch (com.itextpdf.text.DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			document.close();
		}

	}

}
