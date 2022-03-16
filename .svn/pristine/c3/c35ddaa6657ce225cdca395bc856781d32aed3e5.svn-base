package com.saydept.report;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public abstract class ReportDataSource implements JRDataSource{

	@Override
	public abstract boolean next() throws JRException;

	@Override
	public abstract Object getFieldValue(JRField jrField) throws JRException;
	
	/**
	 * 보고서용 파라미터 생성
	 * @return
	 */
	public abstract Map<String, Object> getReportParameter();
	
	/**
	 * 보고서 디자인 파일 InputStream 생성
	 * @return
	 * @throws IOException
	 */
	public abstract InputStream getReportInputStream() throws IOException;
	
	/**
	 * 보고서 출력용 OutputStream 생성
	 * @param res
	 * @return
	 * @throws IOException
	 */
	public OutputStream getReportOutputStream(HttpServletResponse res) throws IOException {
		res.setHeader("Content-type", "application/pdf;charset=utf-8");
		res.setHeader("Content-disposition", "inline; filename=HttpServletResponse.pdf");
		return res.getOutputStream();
	}

}
