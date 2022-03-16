package com.saydept.api.spf.excel.dayAggregation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.excel.dayAggregation.model.DayAggregationModel;
import com.saydept.api.spf.excel.dayAggregation.model.DayAggregationParamModel;
import com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts.ConerPlanCntstPerfomStsExcelGenerator;
import com.saydept.utils.SayUtils;

@CrossOrigin(origins = "*")
@RestController
public class DayAggregationController {

	@Autowired
	private DayAggregationService dayAggregationService;
	@Autowired
	private SayUtils sayUtils;


	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/dayAggregation", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	//엑셀소스
	   @RequestMapping(value="api/dayAggregation/excel")
	   public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		   System.out.println("엑셀클릭");
	      response.setContentType("application/vnd.ms-excel");
	      response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=dayAggregation.xlsx");
	      System.out.println(request);
	      DayAggregationParamModel requestData = (DayAggregationParamModel) sayUtils.requestJson(request.getParameter("param"), DayAggregationParamModel.class);
	      System.out.println(requestData);
	      
	       try {
	    	   
	    	   List<DayAggregationModel> result = dayAggregationService.selectListDayAggregation(requestData);   
	    	   //데이터생성
	           System.out.println(result);
	          // System.out.println(result2);
	         //엑셀생성
	    	   ByteArrayInputStream in = DayAggregationExcelGenerator.toExcel(result);
			 //허공으로 
			      response.getOutputStream().write(in.readAllBytes());
			  //엑셀생성

	          
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
		        
		         e.printStackTrace();
	        } 
	      
	      return;
	    }
	

	   @RequestMapping(value="api/dayAggregation/excel2")
	   public void progListExcel2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		   System.out.println("엑셀클릭");
	      response.setContentType("application/vnd.ms-excel");
	      response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=dayAggregation2.xlsx");
	      System.out.println(request);
	      DayAggregationParamModel requestData = (DayAggregationParamModel) sayUtils.requestJson(request.getParameter("param"), DayAggregationParamModel.class);
	      System.out.println(requestData);
	      
	       try {
	    	   
	    	   List<DayAggregationModel> result2 = dayAggregationService.selectListDayAggregation2(requestData);   
	    	  
	           System.out.println(result2);
			  //엑셀생성
			   ByteArrayInputStream in2 = DayAggregationExcelGenerator.toExcel2(result2);
			   //허공으로 
				  response.getOutputStream().write(in2.readAllBytes());
			      
	          
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
		        
		         e.printStackTrace();
	        } 
	      
	     

	      return;
	    }
	   
	   @RequestMapping(value="api/dayAggregation/excel3")
	   public void progListExcel3(HttpServletRequest request, HttpServletResponse response) throws IOException {
		   System.out.println("엑셀클릭");
	      response.setContentType("application/vnd.ms-excel");
	      response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=dayAggregation3.xlsx");
	      System.out.println(request);
	      DayAggregationParamModel requestData = (DayAggregationParamModel) sayUtils.requestJson(request.getParameter("param"), DayAggregationParamModel.class);
	      System.out.println(requestData);
	      
	       try {
	    	   
	    	   List<DayAggregationModel> result = dayAggregationService.selectListDayAggregation3(requestData);   
	    	  
	           System.out.println(result);
			  //엑셀생성
			   ByteArrayInputStream in = DayAggregationExcelGenerator.toExcel3(result);
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