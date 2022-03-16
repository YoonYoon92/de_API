package com.saydept.api.app.appSayPlusCoupon;

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

import com.saydept.api.app.appSayPlusCoupon.model.AppSayPlusCouponModel;
import com.saydept.api.app.appSayPlusCoupon.model.AppSayPlusCouponParamModel;
import com.saydept.api.app.appSayResign.model.AppSayResignModel;
//import com.saydept.api.app.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

@CrossOrigin(origins = "*")
@RestController
public class AppSayPlusCouponController {
	
	@Autowired
	private AppSayPlusCouponService appSayPlusCouponService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
//	@RequestMapping(value = "api/appSayPlusCoupon", method = RequestMethod.GET)
//	public String condition() throws ParseException {
//		
//		//System.out.println( new SayUtils().getCusomYear("20200603", -1) );
//		
//		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//	}
	
	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectTamplate1List
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/appSayPlusCoupon/selectAppSayPlusCouponList")
	public List<AppSayPlusCouponModel> appSayPlusCouponList(@RequestBody AppSayPlusCouponParamModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
		System.out.println(request); 					//로그 찍기
   try {   
		appSayPlusCouponService.appSayPlusCouponList(request);
	    } catch (Exception e) {
	    return appSayPlusCouponService.appSayPlusCouponList(request);
	    } 
		return appSayPlusCouponService.appSayPlusCouponList(request);
	}
	//쿠폰구분자A 출력
	@RequestMapping(value = "api/appSayPlusCoupon/selectAppSayPlusCouponListA")
	public List<AppSayPlusCouponModel> appSayPlusCouponListA(@RequestBody AppSayPlusCouponParamModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
		System.out.println(request); 					//로그 찍기
   try {   
		appSayPlusCouponService.appSayPlusCouponListA(request);
	    } catch (Exception e) {
	    return appSayPlusCouponService.appSayPlusCouponListA(request);
	    } 
		return appSayPlusCouponService.appSayPlusCouponListA(request);
	}
	
	 // Excel Download
	   @RequestMapping(value="api/appSayPlusCoupon/downloadExcel")
    public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.setContentType("application/vnd.ms-excel");
       response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=appSayPlusCoupon.xlsx");
       
       AppSayPlusCouponParamModel requestData = (AppSayPlusCouponParamModel) sayUtils.requestJson(request.getParameter("param"), AppSayPlusCouponParamModel.class);
       System.out.println( "appSayPlusCoupon.controller.excel" );
        try {
           
           //데이터생성
           List<AppSayPlusCouponModel> result = appSayPlusCouponService.appSayPlusCouponList(requestData);
           //this/excel
           //csv생성
           ByteArrayInputStream in = AppSayPlusCouponExcelGenerator.customersToExcel(result);
           //허공으로 
           response.getOutputStream().write(in.readAllBytes());

           //util//excel
//           ExportUtils.exportXLSX(response, "appSayPlusCoupon", appSayPlusCouponList(requestData));
           
         } catch (IOException e) {
             e.printStackTrace();
         } catch (Exception e) {
            
             e.printStackTrace();
         } 

       return;
     }

	/* 테스트 */
	@RequestMapping(value = "api/appSayPlusCoupon/selectAppSayPlusCouponTest")
	public List<AppSayPlusCouponModel> appSayPlusCouponList()throws Exception {
//		http://localhost:8000/api/appSayPlusCoupon/selectAppSayPlusCouponTest?frDate=20200912,toDate=20200912,jum=01,serchLevel=jum,onlineChk=9020860160109266
		AppSayPlusCouponParamModel param = new AppSayPlusCouponParamModel();
		param.setJum("01");
		param.setFrDate("20201203");
		param.setToDate("20201231");
		param.setOnlineChk("9910522350112345");
//		param.setOnlineChk("9020860160109266");
		return appSayPlusCouponService.appSayPlusCouponList(param);
	}
	
	@RequestMapping(value = "api/appSayPlusCoupon/getUseCoupon")
	public AppSayPlusCouponModel getUseCoupon(AppSayPlusCouponModel request)throws Exception {
//		request.setCpNo("AA21716000001");
		System.out.println(request);
		AppSayPlusCouponModel result = appSayPlusCouponService.getUseCoupon(request);
		return result;
	}
	

}