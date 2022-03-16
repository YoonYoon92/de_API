package com.saydept.api.app.appSayPlusSale;

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

import com.saydept.api.app.appSayPlusSale.model.AppSayPlusSaleModel;
import com.saydept.api.app.appSayPlusSale.model.AppSayPlusSaleParamModel;
//import com.saydept.api.app.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

@CrossOrigin(origins = "*")
@RestController
public class AppSayPlusSaleController {
	
	@Autowired
	private AppSayPlusSaleService appSayPlusSaleService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/appSayPlusSale", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/appSayPlusSale/selectAppSayPlusSaleList")
	public List<AppSayPlusSaleModel> appSayPlusSaleList(@RequestBody AppSayPlusSaleParamModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
		System.out.println(request); 					//로그 찍기
   
		appSayPlusSaleService.appSayPlusSaleList(request);
		return appSayPlusSaleService.appSayPlusSaleList(request);
	}
	
	 // Excel Download
	   @RequestMapping(value="api/appSayPlusSale/downloadExcel")
    public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.setContentType("application/vnd.ms-excel");
       response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=appSayPlusSale.xlsx");
       
       AppSayPlusSaleParamModel requestData = (AppSayPlusSaleParamModel) sayUtils.requestJson(request.getParameter("param"), AppSayPlusSaleParamModel.class);
       System.out.println( "appSayPlusSale.controller.excel" );
        try {
           
           //데이터생성
           List<AppSayPlusSaleModel> result = appSayPlusSaleService.appSayPlusSaleList(requestData);
           //this/excel
           //csv생성
           ByteArrayInputStream in = AppSayPlusSaleExcelGenerator.customersToExcel(result);
           //허공으로 
           response.getOutputStream().write(in.readAllBytes());

           //util//excel
//           ExportUtils.exportXLSX(response, "appSayPlusSale", appSayPlusSaleList(requestData));
           
         } catch (IOException e) {
             e.printStackTrace();
         } catch (Exception e) {
            
             e.printStackTrace();
         } 

       return;
     }

	/* 테스트 */
	@RequestMapping(value = "api/appSayPlusSale/selectAppSayPlusSaleTest")
	public List<AppSayPlusSaleModel> appSayPlusSaleList()throws Exception {
		
		AppSayPlusSaleParamModel param = new AppSayPlusSaleParamModel();
		param.setFrDate("20200101");
		param.setToDate("20201231");
		param.setJum("01");
//		param.setSerchLevel("jum");
		param.setOnlineChk("9020860160109266");
		System.out.println(param); 					//로그 찍기
//		List<AppSayPlusSaleModel> result = appSayPlusSaleService.appSayPlusSaleList(param);
		
		return appSayPlusSaleService.appSayPlusSaleList(param);
	}
	

}