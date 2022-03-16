package com.saydept.api.spf.saleNews.corpSaleBrkNsPrnt;

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

import com.saydept.api.spf.saleNews.corpSaleBrkNsPrnt.model.CorpSaleBrkNsPrntModel;
import com.saydept.api.spf.saleNews.corpSaleBrkNsPrnt.model.CorpSaleBrkNsPrntParamModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

@CrossOrigin(origins = "*")
@RestController
public class CorpSaleBrkNsPrntController {
	
	@Autowired
	private CorpSaleBrkNsPrntService corpSaleBrkNsPrntService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/corpSaleBrkNsPrnt", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/corpSaleBrkNsPrnt/selectCorpSaleBrkNsPrntList")
	public List<CorpSaleBrkNsPrntModel> corpSaleBrkNsPrntList(@RequestBody CorpSaleBrkNsPrntParamModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
		System.out.println(request); 					//로그 찍기
   
		corpSaleBrkNsPrntService.corpSaleBrkNsPrntList(request);
		return corpSaleBrkNsPrntService.corpSaleBrkNsPrntList(request);
	}
	
	 // Excel Download
	   @RequestMapping(value="api/corpSaleBrkNsPrnt/downloadExcel")
	   public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/vnd.ms-excel");
    response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=corpSaleBrkNsPrnt.xlsx");
    
    CorpSaleBrkNsPrntParamModel requestData = (CorpSaleBrkNsPrntParamModel) sayUtils.requestJson(request.getParameter("param"), CorpSaleBrkNsPrntParamModel.class);
    System.out.println( "corpSaleBrkNsPrnt.controller.excel" );
     try {
        
        //데이터생성
        List<CorpSaleBrkNsPrntModel> result = corpSaleBrkNsPrntService.corpSaleBrkNsPrntList(requestData);
        //this/excel
        //csv생성
        ByteArrayInputStream in = CorpSaleBrkNsPrntExcelGenerator.customersToExcel(result);
        //허공으로 
        response.getOutputStream().write(in.readAllBytes());

        //util//excel
//        ExportUtils.exportXLSX(response, "corpSaleBrkNsPrnt", corpSaleBrkNsPrntList(requestData));
        
      } catch (IOException e) {
          e.printStackTrace();
      } catch (Exception e) {
         
          e.printStackTrace();
      } 

    return;
  }
	   
	/* 테스트 */
	@RequestMapping(value = "api/spf/saleNews/CorpSaleBrkNsPrnttest")
	public List<CorpSaleBrkNsPrntModel> corpSaleBrkNsPrntList()throws Exception {

		CorpSaleBrkNsPrntParamModel param = new CorpSaleBrkNsPrntParamModel();
		param.setJum("01");
		param.setBu("0171");
		param.setTim("017171");
//		param.setPc("01717176");
		param.setSerchLevel("jum");
		param.setFrDate("20200603");
		param.setToDate("20200604");
		param.setFrDateLy("20190603");
		param.setToDateLy("20190604");
		
//		List<CorpSaleBrkNsPrntModel> result = corpSaleBrkNsPrntService.corpSaleBrkNsPrntList(param);
		
		return corpSaleBrkNsPrntService.corpSaleBrkNsPrntList(param);
	}
	

}