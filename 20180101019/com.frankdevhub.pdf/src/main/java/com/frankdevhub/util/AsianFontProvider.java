package com.frankdevhub.util;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;

public class AsianFontProvider extends XMLWorkerFontProvider {
	private static final Logger LOGGER = Logger.getLogger(AsianFontProvider.class);

	public Font getFont(final String fontname, final String encoding, final boolean embedded, final float size,
			final int style, final BaseColor color) {
		BaseFont bf = null;
		try {
			bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Font font = new Font(bf, size, style, color);
		font.setColor(color);
		LOGGER.debug("FONT:" + fontname);
		return font;
	}
}
