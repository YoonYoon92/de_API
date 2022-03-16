package com.saydept.api.spf.org.nonSalesCornerByPeriodMgt;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.comm.model.ResModel;
import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtCornerClosedModel;
import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtModel;
import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtParamModel;
import com.saydept.utils.SayUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@CrossOrigin(origins = "*")
@RestController
public class NonSalesCornerByPeriodMgtController {
	
	@Autowired
	private SayUtils sayUtils;
	
	@Autowired
	private NonSalesCornerByPeriodMgtService nonSalesCornerByPeriodMgtService;
	
	
	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/NonSalesCornerByPeriodMgtApiChk", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 미사용 코너 리스트 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectNonSalesCornerByPeriodList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/nonSalesCornerByPeriodMgt/selectNonSalesCornerByPeriodList", method = RequestMethod.POST)
	public ResModel selectNonSalesCornerByPeriodList(@RequestBody NonSalesCornerByPeriodMgtParamModel request, HttpServletRequest httpServletRequest)throws Exception {
		
		System.out.println("점 : "+ request.getJum() + ", 시작일 :"+ request.getFromSaleDate() + ", 종료일 :" + request.getToSaleDate());
		
		List<NonSalesCornerByPeriodMgtModel> result = nonSalesCornerByPeriodMgtService.selectNonSalesCornerByPeriodList(request);
		
		ResModel resModel = new ResModel();
		if(result != null) {
			resModel.setCode("000");
			resModel.setMessage("정상입니다.");
			resModel.setData(result);
		} else {
			resModel.setCode("900");
			resModel.setMessage("자료가 없습니다. ");
			resModel.setData(null);
		}		
		
    	return resModel;
		
	}
	
	/**
	 * 미사용 코너 폐기
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/nonSalesCornerByPeriodMgt/updateNonSalesCornerClosed", method = RequestMethod.POST)
	public void updateNonSalesCornerClosed(@RequestBody List<NonSalesCornerByPeriodMgtCornerClosedModel> request)throws Exception {
		System.out.println(request);
		nonSalesCornerByPeriodMgtService.updateNonSalesCornerClosed(request);		
	}
	
	
	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectNonSalesCornerByPeriodList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/nonSalesCornerByPeriodMgt/selectNonSalesCornerByPeriodListTest")
	public List<NonSalesCornerByPeriodMgtModel> selectNonSalesCornerByPeriodList()throws Exception {
		NonSalesCornerByPeriodMgtParamModel param = new NonSalesCornerByPeriodMgtParamModel();
		
		param.setJum("01");
		param.setFromSaleDate("20210401");
		param.setToSaleDate("20210401");
		
		List<NonSalesCornerByPeriodMgtModel> result = nonSalesCornerByPeriodMgtService.selectNonSalesCornerByPeriodList(param);
		return result;
		
	}
	
	//레포트 테스트
	@RequestMapping(value="api/nonSalesCornerByPeriodMgt/pdf")
	public void nonSalesCornerByPeriodListPdf(HttpServletRequest request, HttpServletResponse response) throws IOException, JRException{
		
		//클라이언트에서 온 param(json 문자열을 api에서 사용할 model 객체로 변환한다
		NonSalesCornerByPeriodMgtParamModel requestData = (NonSalesCornerByPeriodMgtParamModel) sayUtils.requestJson(request.getParameter("param"), NonSalesCornerByPeriodMgtParamModel.class);
		
		try {
			List<NonSalesCornerByPeriodMgtModel> result = nonSalesCornerByPeriodMgtService.selectNonSalesCornerByPeriodList(requestData);
			
			System.out.println(result);
			
	//		for(int i = 0; i<100; i++) {
	//			CornerRtnStsModel sampleBean = new CornerRtnStsModel();
	//			sampleBean.setName("ssof222222 "+ i);
	//			sampleBean.setColor("red22222 " + i);
	//			dataList.add(sampleBean);
	//		}
			
			
			String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "report\\spf\\saleNews\\cornerRtnSts\\CornerRtnSts.jasper").getAbsolutePath();
					
			Map<String, Object> parameters = new HashMap<String, Object>();
			
//			parameters.put("fromDate",  requestData.getFromSaleDate.substring(0, 4)+"-"+requestData.getStartDt().substring(4, 6)+"-"+requestData.getStartDt().substring(6, 8));
//			parameters.put("toDate", requestData.getEndDt().substring(0, 4)+"-"+requestData.getEndDt().substring(4, 6)+"-"+requestData.getEndDt().substring(6, 8));
//			parameters.put("paramJumCd", requestData.getJum());
//			
//
//			parameters.put("pgmId", requestData.getPgmId());
//			parameters.put("userId", requestData.getUserId());
//			parameters.put("userName", requestData.getUserName());
//			parameters.put("paramBuCd", (requestData.getBu()==null||requestData.getBu().isBlank())?"":requestData.getBu().substring(2, 4));
//		 	parameters.put("paramTimCd", (requestData.getTim()==null||requestData.getTim().isBlank())?"":requestData.getTim().substring(4, 6));	
			
			
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
	
	
	//csv creation
	@RequestMapping(value="api/nonSalesCornerByPeriodMgt/csv")
	public void nonSalesCornerByPeriodListCsv(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=nonSalesCornerByPeriodMgt.csv");

		// \ufeff = 유니코드 시작바이트     
		response.getWriter().write('\ufeff');
		//Column Header Creation
		CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(),CSVFormat.DEFAULT.withHeader("점","점명","부","부명","팀","팀명","세분류","세분류명","코너번호", "코너명","등록일"));
		
		NonSalesCornerByPeriodMgtParamModel requestData = (NonSalesCornerByPeriodMgtParamModel) sayUtils.requestJson(request.getParameter("param"), NonSalesCornerByPeriodMgtParamModel.class);

		try {
			// Data Creation
			List<NonSalesCornerByPeriodMgtModel> result = nonSalesCornerByPeriodMgtService.selectNonSalesCornerByPeriodList(requestData);  

			// CSV 생성
			for (NonSalesCornerByPeriodMgtModel node : result) {
				csvPrinter.printRecord(Arrays.asList(node.getJumNo().toString()+"\t", node.getJumName(), node.getBuNo().toString()+"\t", node.getBuName(), node.getTeamNo().toString()+"\t", node.getTeamName(), node.getPcNo().toString()+"\t", node.getPcName(), node.getCornerNo().toString()+"\t", node.getCornerName(), node.getRegiDate()));
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
	@RequestMapping(value="api/nonSalesCornerByPeriodMgt/excel")
	public void nonSalesCornerByPeriodListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("application/vnd.ms-excel");
		
		response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=nonSalesCornerByPeriodMgt.xlsx");

		NonSalesCornerByPeriodMgtParamModel requestData = (NonSalesCornerByPeriodMgtParamModel) sayUtils.requestJson(request.getParameter("param"), NonSalesCornerByPeriodMgtParamModel.class);

		try {
			// Data Creation
			List<NonSalesCornerByPeriodMgtModel> result = nonSalesCornerByPeriodMgtService.selectNonSalesCornerByPeriodList(requestData);  

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
	
	//폐기코너 excel creation
	@RequestMapping(value="api/nonSalesCornerByPeriodMgt/excelCornerClosed", method = RequestMethod.GET)
	public void nonSalesCornerClosedListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("request.getParameter:" + request.getParameter("param"));
		
		List<NonSalesCornerByPeriodMgtCornerClosedModel> nonSalesCornerByPeriodMgtCornerClosedModel = new ArrayList<> ();
		
		try {
			JSONArray jsonArray = new JSONArray(request.getParameter("param"));
			
			for(int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				NonSalesCornerByPeriodMgtCornerClosedModel requestJson = (NonSalesCornerByPeriodMgtCornerClosedModel) sayUtils.requestJson(jsonObject.toString(), NonSalesCornerByPeriodMgtCornerClosedModel.class);
				nonSalesCornerByPeriodMgtCornerClosedModel.add(requestJson);
			}
			
			response.setContentType("application/vnd.ms-excel");
			
			response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=cornerClosedList.xlsx");
	
			// excel 생성
			ByteArrayInputStream in = ExcelGenerator.toExcelCornerClosed(nonSalesCornerByPeriodMgtCornerClosedModel);
	        
	        response.getOutputStream().write(in.readAllBytes());
	
			return;
		
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
	}
}
