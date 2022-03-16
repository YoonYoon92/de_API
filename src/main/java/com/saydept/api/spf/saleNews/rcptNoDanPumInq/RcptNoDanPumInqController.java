package com.saydept.api.spf.saleNews.rcptNoDanPumInq;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.saleNews.rcptNoDanPumInq.model.RcptNoDanPumInqModel;
import com.saydept.api.spf.saleNews.rcptNoDanPumInq.model.RcptNoDanPumInqParamModel;
import com.saydept.api.spf.saleNews.rcptNoDanPumInq.model.RcptNoDanPumInqSearchModel;
//import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

@CrossOrigin(origins = "*")
@RestController
public class RcptNoDanPumInqController {
	
	@Autowired
	private RcptNoDanPumInqService rcptNoDanPumInqService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/rcptNoDanPumInq", method = RequestMethod.GET)
	public String condition() throws ParseException {
		
		//System.out.println( new SayUtils().getCusomYear("20200603", -1) );
		
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
	@RequestMapping(value = "api/rcptNoDanPumInq/selectRcptNoDanPumInqList")
	public List<RcptNoDanPumInqModel> rcptNoDanPumInqList(@RequestBody RcptNoDanPumInqParamModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
		System.out.println(request); 					//로그 찍기
   
		rcptNoDanPumInqService.rcptNoDanPumInqList(request);
		return rcptNoDanPumInqService.rcptNoDanPumInqList(request);
	}
	
	@RequestMapping(value = "api/rcptNoDanPumInq/selectRcptNoDanPumInqSearchList")
	public List<RcptNoDanPumInqSearchModel> rcptNoDanPumInqRegiList(@RequestBody RcptNoDanPumInqSearchModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
		System.out.println(request); 					//로그 찍기
   
		rcptNoDanPumInqService.rcptNoDanPumInqSearchList(request);
		return rcptNoDanPumInqService.rcptNoDanPumInqSearchList(request);
	}
	
	 // Excel Download
	   @RequestMapping(value="api/rcptNoDanPumInq/downloadExcel")
   public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.setContentType("application/vnd.ms-excel");
      response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=rcptNoDanPumInq.xlsx");
      
      RcptNoDanPumInqParamModel requestData = (RcptNoDanPumInqParamModel) sayUtils.requestJson(request.getParameter("param"), RcptNoDanPumInqParamModel.class);
      System.out.println( "rcptNoDanPumInq.controller.excel" );
       try {
          
          //데이터생성
          List<RcptNoDanPumInqModel> result = rcptNoDanPumInqService.rcptNoDanPumInqList(requestData);
          //this/excel
          //csv생성
          ByteArrayInputStream in = RcptNoDanPumInqExcelGenerator.customersToExcel(result);
          //허공으로 
          response.getOutputStream().write(in.readAllBytes());

          //util//excel
//          ExportUtils.exportXLSX(response, "rcptNoDanPumInq", rcptNoDanPumInqList(requestData));
          
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
           
            e.printStackTrace();
        } 

      return;
    }
	/* 테스트 */
	@RequestMapping(value = "api/spf/saleNews/RcptNoDanPumInqtest")
	public List<RcptNoDanPumInqModel> rcptNoDanPumInqList()throws Exception {

		RcptNoDanPumInqParamModel param = new RcptNoDanPumInqParamModel();
		
		param.setJum("01");
//		param.setBu("0171");
//		param.setTim("017171");
//		param.setPc("01717176");
//		param.setSerchLevel("jum");
		param.setFrDate("20200908");
		param.setRegiNo("8283");
//		param.setRcptNo1("0001");
//		param.setRcptNo1("9999");
//		param.setToDateLy("20190604");
		
//		List<RcptNoDanPumInqModel> result = rcptNoDanPumInqService.rcptNoDanPumInqList(param);
		System.out.println(param); 					//로그 찍기
		return rcptNoDanPumInqService.rcptNoDanPumInqList(param);
	}
	

}