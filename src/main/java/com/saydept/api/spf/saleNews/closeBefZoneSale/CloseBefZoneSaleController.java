package com.saydept.api.spf.saleNews.closeBefZoneSale;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.report.ReportModel;
import com.saydept.api.spf.saleNews.closeBefZoneSale.model.CloseBefZoneSaleModel;
import com.saydept.utils.SayUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@CrossOrigin(origins = "*")
@RestController
public class CloseBefZoneSaleController {

	@Autowired
	private CloseBefZoneSaleService closeBefZoneSaleService;

	@Autowired
	private SayUtils sayUtils;
	
		
	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/closeBefZoneSale", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectCloseBefZoneSale
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/closeBefZoneSale/selectCloseBefZoneSale", method = RequestMethod.POST)
	public CloseBefZoneSaleModel selectCloseBefZoneSale(@RequestBody CloseBefZoneSaleModel request)throws Exception {

		CloseBefZoneSaleModel result = closeBefZoneSaleService.selectCloseBefZoneSale(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectCloseBefZoneSaleList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/closeBefZoneSale/selectCloseBefZoneSaleList", method = RequestMethod.POST)
	public List<CloseBefZoneSaleModel> selectCloseBefZoneSaleList(@RequestBody CloseBefZoneSaleModel request)throws Exception {

		List<CloseBefZoneSaleModel> result = closeBefZoneSaleService.selectCloseBefZoneSaleList(request);
		return result;
	}

	
	//레포트 테스트
	@RequestMapping(value="api/closeBefZoneSale/reportCloseBefZoneSaleList")
	public void progList(HttpServletRequest request, HttpServletResponse response) throws IOException, JRException{
		
		//클라이언트에서 온 param(json 문자열을 api에서 사용할 model 객체로 변환한다
		ReportModel reportModel = (ReportModel) sayUtils.requestJson(request.getParameter("param"), ReportModel.class);
		

		
		List<Object> dataList = new ArrayList<Object>();
		
		for( int i=0;i<4;i++) {
			ReportModel sampleBean = new ReportModel();
			sampleBean.setBaseName("AAAAAAAAAAA");
			sampleBean.setName("sayHMS");
			sampleBean.setColor("blue"+i);
			sampleBean.setItemId(i+"item");
			sampleBean.setPrice(i);
			
			dataList.add(sampleBean);			
		}
		for( int i=0;i<2;i++) {
			ReportModel sampleBean = new ReportModel();
			sampleBean.setBaseName("AAAAAAAAAAA");
			sampleBean.setName("ABC");
			sampleBean.setColor("blue"+i);
			sampleBean.setItemId(i+"item");
			sampleBean.setPrice(i);
			
			dataList.add(sampleBean);			
		}
		for( int i=0;i<3;i++) {
			ReportModel sampleBean = new ReportModel();
			sampleBean.setBaseName("AAAAAAAAAAA");
			sampleBean.setName("KOREA");
			sampleBean.setColor("blue"+i);
			sampleBean.setItemId(i+"item");
			sampleBean.setPrice(i);
			
			dataList.add(sampleBean);			
		}
		for( int i=0;i<5;i++) {
			ReportModel sampleBean = new ReportModel();
			sampleBean.setBaseName("BBBBBBBBBBBB");
			sampleBean.setName("sayHMS");
			sampleBean.setColor("blue"+i);
			sampleBean.setItemId(i+"item");
			sampleBean.setPrice(i);
			
			dataList.add(sampleBean);			
		}
		for( int i=0;i<3;i++) {
			ReportModel sampleBean = new ReportModel();
			sampleBean.setBaseName("BBBBBBBBBBBB");
			sampleBean.setName("ABC");
			sampleBean.setColor("blue"+i);
			sampleBean.setItemId(i+"item");
			sampleBean.setPrice(i);
			
			dataList.add(sampleBean);			
		}
		for( int i=0;i<5;i++) {
			ReportModel sampleBean = new ReportModel();
			sampleBean.setBaseName("BBBBBBBBBBBB");
			sampleBean.setName("KOREA");
			sampleBean.setColor("blue"+i);
			sampleBean.setItemId(i+"item");
			sampleBean.setPrice(i);
			
			dataList.add(sampleBean);			
		}
		
		
		//String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "report\\closeBefZoneSale\\closeBefZoneSale.jasper").getAbsolutePath();
		String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "report\\spf\\saleNews\\closeBefZoneSale\\Test.jasper" + 
				"").getAbsolutePath();
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("item", "item_name");
		
		parameters.put("stDt", new Date());
		
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
		
		//================================================================================================================================================================
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
		
		//================================================================================================================================================================	
		JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		

		
		return;

	}
	
	
	
	
	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateCloseBefZoneSale
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/closeBefZoneSale/updateCloseBefZoneSale", method = RequestMethod.POST)
	public int updateCloseBefZoneSale(@RequestBody CloseBefZoneSaleModel request)throws Exception {

		int result = closeBefZoneSaleService.updateCloseBefZoneSale(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertCloseBefZoneSale
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/closeBefZoneSale/insertCloseBefZoneSale", method = RequestMethod.POST)
	public int insertCloseBefZoneSale(@RequestBody CloseBefZoneSaleModel request)throws Exception {

		int result = closeBefZoneSaleService.insertCloseBefZoneSale(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveCloseBefZoneSale
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/closeBefZoneSale/saveCloseBefZoneSale", method = RequestMethod.POST)
	public int saveCloseBefZoneSale(@RequestBody CloseBefZoneSaleModel request)throws Exception {

		int result = closeBefZoneSaleService.saveCloseBefZoneSale(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteCloseBefZoneSale
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/closeBefZoneSale/deleteCloseBefZoneSale", method = RequestMethod.POST)
	public int deleteCloseBefZoneSale(@RequestBody CloseBefZoneSaleModel request)throws Exception {

		int result = closeBefZoneSaleService.deleteCloseBefZoneSale(request);
		return result;
	}

}