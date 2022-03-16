package com.saydept.api.spf.saleNews.cornerRtnSts;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.saleNews.cornerRtnSts.model.CornerRtnStsModel;
import com.saydept.api.spf.saleNews.cornerRtnSts.model.CornerRtnStsParamModel;
import com.saydept.utils.SayUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@CrossOrigin(origins = "*")
@RestController
public class CornerRtnStsController {

	@Autowired
	private SayUtils sayUtils;
	
	@Autowired
	private CornerRtnStsService CornerRtnStsService;

	//레포트 테스트
	@RequestMapping(value="api/report/cornerRtnSts/selectReport")
	public void progList(HttpServletRequest request, HttpServletResponse response) throws IOException, JRException{
		
		//클라이언트에서 온 param(json 문자열을 api에서 사용할 model 객체로 변환한다
		CornerRtnStsParamModel requestData = (CornerRtnStsParamModel) sayUtils.requestJson(request.getParameter("param"), CornerRtnStsParamModel.class);
		
		try {
			List<CornerRtnStsModel> result = CornerRtnStsService.selectCornerRtnStsList(requestData);
			
			System.out.println(result);
			
	//		for(int i = 0; i<100; i++) {
	//			CornerRtnStsModel sampleBean = new CornerRtnStsModel();
	//			sampleBean.setName("ssof222222 "+ i);
	//			sampleBean.setColor("red22222 " + i);
	//			dataList.add(sampleBean);
	//		}
			
			
			String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "report\\spf\\saleNews\\cornerRtnSts\\CornerRtnSts.jasper").getAbsolutePath();
					
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("fromDate",  requestData.getStartDt().substring(0, 4)+"-"+requestData.getStartDt().substring(4, 6)+"-"+requestData.getStartDt().substring(6, 8));
			parameters.put("toDate", requestData.getEndDt().substring(0, 4)+"-"+requestData.getEndDt().substring(4, 6)+"-"+requestData.getEndDt().substring(6, 8));
			parameters.put("paramJumCd", requestData.getJum());
			

			parameters.put("pgmId", requestData.getPgmId());
			parameters.put("userId", requestData.getUserId());
			parameters.put("userName", requestData.getUserName());
			parameters.put("paramBuCd", (requestData.getBu()==null||requestData.getBu().isBlank())?"":requestData.getBu().substring(2, 4));
		 	parameters.put("paramTimCd", (requestData.getTim()==null||requestData.getTim().isBlank())?"":requestData.getTim().substring(4, 6));	
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(result);
			
			/*--------------------------------------------------------------------------------------------------*/
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
			/*--------------------------------------------------------------------------------------------------*/
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	
	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/cornerRtnSts", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectNewBrandSaleInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/cornerRtnSts/selectCornerRtnStsList", method = RequestMethod.POST)
	public List<CornerRtnStsModel> selectCornerRtnStsList(@RequestBody CornerRtnStsParamModel request)throws Exception {

		List<CornerRtnStsModel> result = CornerRtnStsService.selectCornerRtnStsList(request);
		return result;
	}
	
	/**
	 * 복수 대상 조회(test)
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectNewBrandSaleInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/cornerRtnSts/selectCornerRtnStsListTest")
	public List<CornerRtnStsModel> selectCornerRtnStsList()throws Exception {
		
		CornerRtnStsParamModel param = new CornerRtnStsParamModel();
		
		param.setJum(param.getJum());
		param.setStartDt(param.getStartDt());
		param.setEndDt(param.getEndDt());
		
		List<CornerRtnStsModel> result = CornerRtnStsService.selectCornerRtnStsList(param);
		return result;
	}
	
	//csv creation
	@RequestMapping(value="api/report/cornerRtnSts/report/csv")
	public void progListCsv(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=CornerRtnSts.csv");

		// \ufeff = 유니코드 시작바이트     
		response.getWriter().write('\ufeff');
		//Column Header Creation
		CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(),CSVFormat.DEFAULT.withHeader("점","점명","부","부명","팀","팀명","코너번호", "코너명","고객변심-건수","고객변심-금액","상품교환-건수","상품교환-금액","결제방법교체-건수","결제방법교체-금액","할인적용-건수","할인적용-금액","고객컴플레인-건수","고객컴플레인-금액","약속불이행-건수","약속불이행-금액","사이즈부적합-건수","사이즈부적합-금액","기타-건수","기타-금액","합계-건수","합계-금액"));
		
		CornerRtnStsParamModel requestData = (CornerRtnStsParamModel) sayUtils.requestJson(request.getParameter("param"), CornerRtnStsParamModel.class);

		try {
			// Data Creation
			List<CornerRtnStsModel> result = CornerRtnStsService.selectCornerRtnStsList(requestData);  

			// CSV 생성
			for (CornerRtnStsModel node : result) {
				csvPrinter.printRecord(Arrays.asList(node.getJumCd().toString()+"\t", node.getJumName(), node.getBuCd().toString()+"\t", node.getBuName(), node.getTimCd().toString()+"\t", node.getTimName(), node.getCornerNo().toString()+"\t", node.getCornerName(), node.getCountOfCustChg(), node.getAmtOfCustChg(), node.getCountOfProductExchg(), node.getAmtOfProductExchg(), node.getCountOfPaymentChg(), node.getAmtOfPaymentChg(), node.getCountOfApplyDiscount(), node.getAmtOfApplyDiscount(), node.getCountOfCustomerComplaint(), node.getAmtOfCustomerComplaint(), node.getCountOfNotPromise(), node.getAmtOfNotPromise(), node.getCountOfSizeNotSuitable(), node.getAmtOfSizeNotSuitable(), node.getCountOfEtc(), node.getAmtOfEtc(), node.getCountOfTotal(), node.getAmtOfTotal()));
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {            
            e.printStackTrace();
        } finally {
			if(csvPrinter != null) csvPrinter.close();
		}
		return;
	}	
	
	
	
	//excel creation
	@RequestMapping(value="api/report/cornerRtnSts/report/excel")
	public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("application/vnd.ms-excel");
		
		response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=CornerRtnSts.xlsx");

		CornerRtnStsParamModel requestData = (CornerRtnStsParamModel) sayUtils.requestJson(request.getParameter("param"), CornerRtnStsParamModel.class);

		try {
			// Data Creation
			List<CornerRtnStsModel> result = CornerRtnStsService.selectCornerRtnStsList(requestData);  

			// excel 생성
			ByteArrayInputStream in = ExcelGenerator.toExcel(result);
            
            response.getOutputStream().write(in.readAllBytes());


		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {            
            e.printStackTrace();
        } 

		return;
	}
	
}