package com.saydept.api.spf.selng.generalCreditSalesInq;

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

import com.saydept.utils.SayUtils;
import com.saydept.api.spf.selng.generalCreditSalesInq.model.GeneralCreditSalesInqModel;
import com.saydept.api.spf.selng.generalCreditSalesInq.model.GeneralCreditSalesInqParamModel;

@CrossOrigin(origins = "*")
@RestController
public class GeneralCreditSalesInqController {

	@Autowired
	private GeneralCreditSalesInqService generalCreditSalesInqService;
	@Autowired
	private SayUtils sayUtils;
	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/spf/selng/selectGeneralCreditSalesInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectSalesByTypeInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/spf/selng/selectGeneralCreditSalesInqList", method = RequestMethod.POST)
	public List<GeneralCreditSalesInqModel> selectGeneralCreditSalesInqList(@RequestBody GeneralCreditSalesInqParamModel request)throws Exception {
		
		List<GeneralCreditSalesInqModel> result = null;
		
		System.out.println("request.getSaleCls():"+request.getSaleCls());
		
		if(request.getSaleCls().equals("1")	|| request.getSaleCls().equals("2")) { //일반외상, 사용매출
			result = generalCreditSalesInqService.selectGeneralCreditSalesInqList(request);
		} else {  //특판, cod
			result = generalCreditSalesInqService.selectGeneralCreditSalesInqListTr(request);
		}
		return result;
	}
	
	 @RequestMapping(value="api/spf/selng/generalCreditSalesInqExcel")
	   public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		   System.out.println("엑셀클릭");
	      response.setContentType("application/vnd.ms-excel");
	      response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generalCreditSalesInq.xlsx");
	      System.out.println(request);
	      GeneralCreditSalesInqParamModel requestData = (GeneralCreditSalesInqParamModel) sayUtils.requestJson(request.getParameter("param"), GeneralCreditSalesInqParamModel.class);
	      System.out.println(requestData);
	      
	       try {
	    	   
	    	   List<GeneralCreditSalesInqModel> result = null;
	   		
		   		System.out.println("request.getSaleCls():"+requestData.getSaleCls());
		   		
		   		if(requestData.getSaleCls().equals("1")	|| requestData.getSaleCls().equals("2")) { //일반외상, 사용매출
		   			result = generalCreditSalesInqService.selectGeneralCreditSalesInqList(requestData);
		   		} else {  //특판, cod
		   			result = generalCreditSalesInqService.selectGeneralCreditSalesInqListTr(requestData);
		   		}
	    	   
	    	 
	    	   //데이터생성
	           System.out.println(result);
	          // System.out.println(result2);
	         //엑셀생성
	    	   ByteArrayInputStream in = GeneralCreditSalesInqExcelGenerator.toExcel(result);
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

}