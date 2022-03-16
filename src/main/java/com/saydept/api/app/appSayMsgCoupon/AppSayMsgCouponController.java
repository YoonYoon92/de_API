package com.saydept.api.app.appSayMsgCoupon;

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

import com.saydept.api.app.appSayMsgCoupon.model.AppSayMsgCouponModel;
import com.saydept.api.app.appSayMsgCoupon.model.AppSayMsgCouponParamModel;
//import com.saydept.api.app.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

@CrossOrigin(origins = "*")
@RestController
public class AppSayMsgCouponController {
	
	@Autowired
	private AppSayMsgCouponService appSayMsgCouponService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/appSayMsgCoupon", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/appSayMsgCoupon/selectAppSayMsgCouponList")
	public List<AppSayMsgCouponModel> appSayMsgCouponList(@RequestBody AppSayMsgCouponParamModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
		System.out.println(request); 					//로그 찍기
   
		appSayMsgCouponService.appSayMsgCouponList(request);
		return appSayMsgCouponService.appSayMsgCouponList(request);
	}
	
	 // Excel Download
	   @RequestMapping(value="api/appSayMsgCoupon/downloadExcel")
    public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.setContentType("application/vnd.ms-excel");
       response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=appSayMsgCoupon.xlsx");
       
       AppSayMsgCouponParamModel requestData = (AppSayMsgCouponParamModel) sayUtils.requestJson(request.getParameter("param"), AppSayMsgCouponParamModel.class);
       System.out.println( "appSayMsgCoupon.controller.excel" );
        try {
           
           //데이터생성
           List<AppSayMsgCouponModel> result = appSayMsgCouponService.appSayMsgCouponList(requestData);
           //this/excel
           //csv생성
           ByteArrayInputStream in = AppSayMsgCouponExcelGenerator.customersToExcel(result);
           //허공으로 
           response.getOutputStream().write(in.readAllBytes());

           //util//excel
//           ExportUtils.exportXLSX(response, "appSayMsgCoupon", appSayMsgCouponList(requestData));
           
         } catch (IOException e) {
             e.printStackTrace();
         } catch (Exception e) {
            
             e.printStackTrace();
         } 

       return;
     }

	/* 테스트 */
	@RequestMapping(value = "api/appSayMsgCoupon/selectAppSayMsgCouponTest")
	public List<AppSayMsgCouponModel> appSayMsgCouponList()throws Exception {
//		http://localhost:8000/api/appSayMsgCoupon/selectAppSayMsgCouponTest?frDate=20200912,toDate=20200912,jum=01,serchLevel=jum,onlineChk=9020860160109266
		AppSayMsgCouponParamModel param = new AppSayMsgCouponParamModel();
		param.setFrDate("20200601");
		param.setToDate("20200601");
		param.setJum("01");
//		param.setSerchLevel("jum");
		param.setOnlineChk("9020860160109266");
// 포인트로 메세지쿠폰 조회해오는 루틴임, 1개월 단위로 조회함
		return appSayMsgCouponService.appSayMsgCouponList(param);
	}
	

}