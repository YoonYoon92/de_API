package com.saydept.report.pdf;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.saydept.report.ReportDataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

@Component
public class CherryDataSource extends ReportDataSource{

	@Override
	public boolean next() throws JRException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getFieldValue(JRField jrField) throws JRException {

		Object value = null;
		if (value == null) value = "";
		
		return value;
	}

	@Override
	public Map<String, Object> getReportParameter() {

		Map<String, Object> parameters = new HashMap<String, Object>();

//		parameters.put("storeNm", storeNm);
//		parameters.put("tot",size);
		return parameters;
	}

	@Override
	public InputStream getReportInputStream() throws IOException {
		
		String reportFile = CherryDataSource.class.getPackage().getName();
		reportFile = reportFile.replace(".", "/") + "/Cherry.jasper";
		URL url = this.getClass().getClassLoader().getResource(reportFile);
		InputStream jasperInputStream = url.openStream();
		return jasperInputStream;
	}

}
