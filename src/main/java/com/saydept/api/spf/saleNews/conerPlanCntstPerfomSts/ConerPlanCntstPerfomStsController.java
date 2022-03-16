package com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.report.ReportModel;
import com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts.model.ConerPlanCntstPerfomStsModel;
import com.saydept.utils.SayUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@CrossOrigin(origins = "*")
@RestController
public class ConerPlanCntstPerfomStsController {

	@Autowired
	private ConerPlanCntstPerfomStsService conerPlanCntstPerfomStsService;
	@Autowired
	private SayUtils sayUtils;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/conerPlanCntstPerfomSts", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	
		@RequestMapping(value = "/api/conerPlanCntstPerfomSts/PcList", method = RequestMethod.POST)
		public List<ConerPlanCntstPerfomStsModel> PcList(@RequestBody ConerPlanCntstPerfomStsModel request)throws Exception {

		List<ConerPlanCntstPerfomStsModel> result = conerPlanCntstPerfomStsService.PcList(request);
		return result;
	}
	
	
		//조회리스트
		@RequestMapping(value = "/api/conerPlanCntstPerfomSts/selectConerPlanCntstPerfomStsList", method = RequestMethod.POST)
		public List<ConerPlanCntstPerfomStsModel> Searcheventlist(@RequestBody ConerPlanCntstPerfomStsModel request)throws Exception {

			List<ConerPlanCntstPerfomStsModel> result = conerPlanCntstPerfomStsService.selectConerPlanCntstPerfomStsList(request);
			return result;
		}
		
		
		@RequestMapping(value = "api/conerPlanCntstPerfomSts/TEST")
		public List<ConerPlanCntstPerfomStsModel> TEST()throws Exception {
		ConerPlanCntstPerfomStsModel result = new ConerPlanCntstPerfomStsModel();
			
			result.setStartDt("20200810");
			result.setJum("01");
			result.setBu("0171");
			result.setTim("017171");
			
			return conerPlanCntstPerfomStsService.selectConerPlanCntstPerfomStsList(result);
		}
		
		
		
		
		//리포트
		@RequestMapping(value="api/conerPlanCntstPerfomSts/selectReport")
		public void progList(HttpServletRequest request, HttpServletResponse response) throws IOException, JRException{
				
			  response.setContentType("application/pdf");
		      response.addHeader(HttpHeaders.CONTENT_DISPOSITION,"inline; filename=jasper.pdf;");
			
			
				
			  //클라이언트에서 온 param(json 문자열을 api에서 사용할 model 객체로 변환한다
			ConerPlanCntstPerfomStsModel requestData = (ConerPlanCntstPerfomStsModel) sayUtils.requestJson(request.getParameter("param"), ConerPlanCntstPerfomStsModel.class);
		                  
		      
		      try {
		    	  List<ConerPlanCntstPerfomStsModel> result = conerPlanCntstPerfomStsService.selectConerPlanCntstPerfomStsList(requestData);   
		    	  //pdf생성
		    	  
		    	  System.out.println(requestData);
		    	  List<Object> dataList = new ArrayList<Object>();
		         //String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "report\\closeBefZoneSale\\closeBefZoneSale.jasper").getAbsolutePath();
		    	 String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "report\\spf\\saleNews\\conerPlanCntstPerfomSts\\conerPlanCntstPerfomSts.jasper").getAbsolutePath();
		         
		         Map<String, Object> parameters = new HashMap<String, Object>();
		         	parameters.put("startDt", requestData.getStartDt());
		         	parameters.put("pgId","conerPlanCntstPerfomSts");
		         	//parameters.put("startDt", "20200816");
		         

		         	
		         	
		                  
		         //JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(result);
		         JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(result);
		         
		         //================================================================================================================================================================
//		         response.setContentType("application/pdf");
//		         response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
		         
		         //================================================================================================================================================================   
		         JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
		         
		         JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		         
		      } catch (Exception e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		      
		      return;

	
		}
		 	
		//CSV소스
		@RequestMapping(value="api/conerPlanCntstPerfomSts/csv")
		   public void progListCsv(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
		      response.setContentType("text/csv");
		      response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=customers.csv");
		      
		      // \ufeff = 유니코드 시작바이트
		      response.getWriter().write('\ufeff');
		      //프린터를 만들때 타이틀값을 준다 (여러개주고싶으면 여러개 작성)
		      CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(),CSVFormat.DEFAULT.withHeader("name", "color"));
			
		      ConerPlanCntstPerfomStsModel requestData = (ConerPlanCntstPerfomStsModel) sayUtils.requestJson(request.getParameter("param"), ConerPlanCntstPerfomStsModel.class);
			      
		      
		    
		       try {
		    	   
		    	   List<ConerPlanCntstPerfomStsModel> result = conerPlanCntstPerfomStsService.selectConerPlanCntstPerfomStsList(requestData);   
		    	   //데이터생성
		           
		         
		         //csv생성
		          for (ConerPlanCntstPerfomStsModel node : result) {
		              csvPrinter.printRecord(Arrays.asList(node.getConerNm(), node.getYyAchivmentrate()));
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

			//엑셀소스
		   @RequestMapping(value="api/conerPlanCntstPerfomSts/excel")
		   public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		      response.setContentType("application/vnd.ms-excel");
		      response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=conerPlanCntstPerfomSts.xlsx");

		      ConerPlanCntstPerfomStsModel requestData = (ConerPlanCntstPerfomStsModel) sayUtils.requestJson(request.getParameter("param"), ConerPlanCntstPerfomStsModel.class);
		      
		      
			    
		       try {
		    	   
		    	   List<ConerPlanCntstPerfomStsModel> result = conerPlanCntstPerfomStsService.selectConerPlanCntstPerfomStsList(requestData);   
		    	   //데이터생성
		           
		         
		         //엑셀생성
		    	   ByteArrayInputStream in = ConerPlanCntstPerfomStsExcelGenerator.toExcel(result);
				      //허공으로 
				      response.getOutputStream().write(in.readAllBytes());

		          
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (Exception e) {
			        
			         e.printStackTrace();
		        } 
		      
		     

		      return;
		    }
}