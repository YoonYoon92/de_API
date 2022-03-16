package com.saydept.api.report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saydept.utils.SayUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@CrossOrigin(origins = "*")
@Controller
public class ReportController {
	
	@Autowired
	private SayUtils sayUtils;

	//레포트 테스트
	@RequestMapping(value="api/report/selectReport")
	public void progList(HttpServletRequest request, HttpServletResponse response) throws IOException, JRException{
		
		//클라이언트에서 온 param(json 문자열을 api에서 사용할 model 객체로 변환한다
		ReportModel reportModel = (ReportModel) sayUtils.requestJson(request.getParameter("param"), ReportModel.class);
		
		String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "report\\Cherry.jasper").getAbsolutePath();
		
		List<Object> dataList = new ArrayList<Object>();
		ReportModel sampleBean = new ReportModel();
		sampleBean.setName("ssof");
		sampleBean.setColor("red");
		dataList.add(sampleBean);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
		JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
		
		return;

	}

}
