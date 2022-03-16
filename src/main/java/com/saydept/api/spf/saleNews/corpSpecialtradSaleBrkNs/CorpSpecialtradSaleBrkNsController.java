package com.saydept.api.spf.saleNews.corpSpecialtradSaleBrkNs;

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

import com.saydept.api.spf.saleNews.corpSpecialtradSaleBrkNs.model.CorpSpecialtradSaleBrkNsModel;
import com.saydept.api.spf.saleNews.corpSpecialtradSaleBrkNs.model.CorpSpecialtradSaleBrkNsParamModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

@CrossOrigin(origins = "*")
@RestController
public class CorpSpecialtradSaleBrkNsController {
	
	@Autowired
	private CorpSpecialtradSaleBrkNsService corpSpecialtradSaleBrkNsService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/corpSpecialtradSaleBrkNs", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/corpSpecialtradSaleBrkNs/selectCorpSpecialtradSaleBrkNsList")
	public List<CorpSpecialtradSaleBrkNsModel> corpSpecialtradSaleBrkNsList(@RequestBody CorpSpecialtradSaleBrkNsParamModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
		System.out.println(request); 					//로그 찍기
   
		corpSpecialtradSaleBrkNsService.corpSpecialtradSaleBrkNsList(request);
		return corpSpecialtradSaleBrkNsService.corpSpecialtradSaleBrkNsList(request);
	}
	
	 // Excel Download
	   @RequestMapping(value="api/corpSpecialtradSaleBrkNs/downloadExcel")
	   public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/vnd.ms-excel");
    response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=corpSpecialtradSaleBrkNs.xlsx");
    
    CorpSpecialtradSaleBrkNsParamModel requestData = (CorpSpecialtradSaleBrkNsParamModel) sayUtils.requestJson(request.getParameter("param"), CorpSpecialtradSaleBrkNsParamModel.class);
    System.out.println( "corpSpecialtradSaleBrkNs.controller.excel" );
     try {
        
        //데이터생성
        List<CorpSpecialtradSaleBrkNsModel> result = corpSpecialtradSaleBrkNsService.corpSpecialtradSaleBrkNsList(requestData);
        //this/excel
        //csv생성
        ByteArrayInputStream in = CorpSpecialtradSaleBrkNsExcelGenerator.customersToExcel(result);
        //허공으로 
        response.getOutputStream().write(in.readAllBytes());

        //util//excel
//        ExportUtils.exportXLSX(response, "corpSpecialtradSaleBrkNs", corpSpecialtradSaleBrkNsList(requestData));
        
      } catch (IOException e) {
          e.printStackTrace();
      } catch (Exception e) {
         
          e.printStackTrace();
      } 

    return;
  }
	/* 테스트 */
	@RequestMapping(value = "api/spf/saleNews/CorpSpecialtradSaleBrkNstest")
	public List<CorpSpecialtradSaleBrkNsModel> corpSpecialtradSaleBrkNsList()throws Exception {

		CorpSpecialtradSaleBrkNsParamModel param = new CorpSpecialtradSaleBrkNsParamModel();
		param.setJum("01");
//		param.setBu("0171");
//		param.setTim("017171");
//		param.setPc("01717176");
		param.setSerchLevel("jum");
		param.setFrDate("20200401");
		param.setToDate("20200428");
//		param.setFrDateLy("20190603");
//		param.setToDateLy("20190604");
		
//		List<CorpSpecialtradSaleBrkNsModel> result = corpSpecialtradSaleBrkNsService.corpSpecialtradSaleBrkNsList(param);
		
		return corpSpecialtradSaleBrkNsService.corpSpecialtradSaleBrkNsList(param);
	}
	

}