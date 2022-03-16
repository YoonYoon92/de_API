package com.saydept.api.spf.saleNews.corpSaleNews;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
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

import com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts.ConerPlanCntstPerfomStsExcelGenerator;
import com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts.model.ConerPlanCntstPerfomStsModel;
import com.saydept.api.spf.saleNews.corpSaleNews.model.CorpSaleNewsModel;
import com.saydept.api.spf.saleNews.corpSaleNews.model.CorpSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@CrossOrigin(origins = "*")
@RestController
public class CorpSaleNewsController {
	
	@Autowired
	private CorpSaleNewsService corpSaleNewsService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/corpSaleNews", method = RequestMethod.GET)
	public String condition() throws ParseException {	
		
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectTamplate1List
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/corpSaleNews/selectCorpSaleNewsList")
	public List<CorpSaleNewsModel> corpSaleNewsList(@RequestBody CorpSaleNewsParamModel request)throws Exception {		
		
//		if(request.getGubun() == "gubunDal") {
//			return corpSaleNewsService.corpSaleNewsListDal(request);	
//		}
//		else if(request.getGubun() == "gubunSin") {
//			return corpSaleNewsService.corpSaleNewsListSin(request);
//		}
//		else if(request.getGubun() == "gubunJin") {
//			return corpSaleNewsService.corpSaleNewsListJin(request);
//		}
//		else 
			return corpSaleNewsService.corpSaleNewsList(request);		
	}
	
	/**
	 * 엑셀다운 - 복수대상조회랑 같이 처리
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectTamplate1List
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/corpSaleNews/excel")
	//public List<CorpSaleNewsModel> excelCorpSaleNewsList(@RequestBody CorpSaleNewsParamModel request)throws Exception {
	//return corpSaleNewsService.corpSaleNewsList(request);
	public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {	
	      response.setContentType("application/vnd.ms-excel");
	      response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=conerPlanCntstPerfomSts.xlsx");

	      CorpSaleNewsParamModel requestData = (CorpSaleNewsParamModel) sayUtils.requestJson(request.getParameter("param"), CorpSaleNewsParamModel.class); 
	       try {	    	   
	    	   List<CorpSaleNewsModel> result = corpSaleNewsService.corpSaleNewsList(requestData);   
	    	   //데이터생성
	         //엑셀생성
	    	   ByteArrayInputStream in = CorpSaleNewsExcelGenerator.toExcel(result);
			      //허공으로 
			      response.getOutputStream().write(in.readAllBytes());
	          
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
		        
		         e.printStackTrace();
	        }      
	      return;
	}
	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectTamplate1List
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/spf/saleNews/test")
	public List<CorpSaleNewsModel> corpSaleNewsList()throws Exception {
		
		CorpSaleNewsParamModel param = new CorpSaleNewsParamModel();
		param.setJum("01");
		param.setSerchLevel("jum");
		param.setSearchDay("20200605");
		
//		List<CorpSaleNewsModel> result = corpSaleNewsService.corpSaleNewsList(param);
		
		return corpSaleNewsService.corpSaleNewsList(param);
	}
	

}