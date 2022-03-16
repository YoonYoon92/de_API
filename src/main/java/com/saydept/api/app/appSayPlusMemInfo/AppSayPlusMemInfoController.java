package com.saydept.api.app.appSayPlusMemInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.app.appSayPlusCoupon.model.AppSayPlusCouponModel;
import com.saydept.api.app.appSayPlusCoupon.model.AppSayPlusCouponParamModel;
import com.saydept.api.app.appSayPlusMemInfo.model.AppSayPlusMemInfoModel;
import com.saydept.api.app.appSayPlusMemInfo.model.AppSayPlusMemInfoParamModel;
import com.saydept.utils.SayUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

@CrossOrigin(origins = "*")
@RestController
public class AppSayPlusMemInfoController {
	
	@Autowired
	private AppSayPlusMemInfoService appSayPlusMemInfoService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	
	@RequestMapping(value = "api/appSayPlusMemInfoPost", method = RequestMethod.POST)
	//	@RequestMapping(value = "api/appSayPlusMemInfoPost")

		public List<AppSayPlusMemInfoModel> appSayPlusMemInfoListPost(@RequestBody AppSayPlusMemInfoParamModel request)throws Exception {
		
		System.out.println("Post "+request); 					//로그 찍기
//		System.out.println("Post "+request.getRemoteAddr()); 					//로그 찍기
//		System.out.println("Post "+request.getLocalAddr()); 					//로그 찍기
		appSayPlusMemInfoService.appSayPlusMemInfoList(request);
		return appSayPlusMemInfoService.appSayPlusMemInfoList(request);
		
//		return "appSayPlusMemInfo.AppSayPlusMemInfoGetTestControllerRequest"
//				+ "<br><br> CitizenNo1 : "
//				+ request.getCitizenNo1("CitizenNo1")
//				+ "<br> MemName : "
//				+ request.getParameter("MemName")
//				+ "<br> HpNo &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : "
//				+ request.getParameter("HpNo")
//				+ "<br><br> citizenno1 : "
//				+ request.getParameter("citizenno1")
//				+ "<br> memname : "
//				+ request.getParameter("memname")
//				+ "<br> hpno &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : "
//				+ request.getParameter("hpno")
////				+ "<br> InputDate &nbsp;&nbsp;: '"
////				+ request.getParameter("InputDate")
////				+ "'"
////				+ "<br> ClientAddr : "
////				+ request.getRemoteAddr()
////				+ " "
////				+ request.getLocalAddr()
//				+ "<br> SimpleDate : "
//				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/appSayPlusMemInfo")
	public String condition_test(HttpServletRequest request) throws ParseException {
		AppSayPlusMemInfoParamModel param = new AppSayPlusMemInfoParamModel();
		if ("POST".equalsIgnoreCase(request.getMethod())) 
		{
		   System.out.println("Info_POST "+param);
		}
		if ("GET".equalsIgnoreCase(request.getMethod())) 
		{
		   System.out.println("Info_GET "+param);
		}
		//System.out.println( new SayUtils().getCusomYear("20200603", -1) );
		//return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//		param.setJum("01");
		param.setCitizenNo1(request.getParameter("CitizenNo1"));
		param.setMemName(request.getParameter("MemName"));
		param.setHpNo(request.getParameter("HpNo"));
//		param.setInputDate(request.getParameter("InputDate"));
		
//		System.out.println("Info "+param); 					//로그 찍기
		System.out.println(request.getRemoteAddr() + " / " + request.getHeader("X-Forwarded-For") + " / " + request.getHeader("Proxy-Client-IP") + " / " + request.getHeader("WL-Proxy-Client-IP") + " / " + request.getHeader("HTTP_CLIENT_IP") + " / " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		return "appSayPlusMemInfo.AppSayPlusMemInfoGetTestControllerRequest"
				+ "<br><br> CitizenNo1 : "
				+ request.getParameter("CitizenNo1")
				+ "<br> MemName : "
				+ request.getParameter("MemName")
				+ "<br> HpNo &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : "
				+ request.getParameter("HpNo")
				+ "<br><br> citizenno1 : "
				+ request.getParameter("citizenno1")
				+ "<br> memname : "
				+ request.getParameter("memname")
				+ "<br> hpno &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : "
				+ request.getParameter("hpno")
//				+ "<br> InputDate &nbsp;&nbsp;: '"
//				+ request.getParameter("InputDate")
//				+ "'"
//				+ "<br> ClientAddr : "
//				+ request.getRemoteAddr()
//				+ " "
//				+ request.getLocalAddr()
				+ "<br> SimpleDate : "
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
	}

//	@RequestMapping(value = "api/appSayPlusMemInfo2")
//	public String condition_test1(HttpServletRequest request)  Map<String , Object> saveCode(@RequestBody Map<String, Object> param) {
//	    String code = (String) param.get("code");
//	    String upCode = (String) param.get("upCode");
//	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectTamplate1List
	 * @param request
	 * @return
	 * @throws Exception
	 */
//	
//	/* get 응답 */
//	@RequestMapping(value = "api/appSayPlusMemInfo/selectAppSayPlusMemInfoParm", method = {RequestMethod.GET,RequestMethod.POST})
//	public List<AppSayPlusMemInfoModel> appSayPlusMemInfoParm(HttpServletRequest request)throws Exception {
//		
////	@RequestMapping(value = "api/appSayPlusMemInfo", method = RequestMethod.GET)
////	public String condition_test(HttpServletRequest request) throws ParseException {
//		
//		AppSayPlusMemInfoParamModel param = new AppSayPlusMemInfoParamModel();
////		param.setJum("01");
//		param.setCitizenNo1(request.getParameter("CitizenNo1"));
//		param.setMemName(request.getParameter("MemName"));
//		param.setHpNo(request.getParameter("HpNo"));
////		param.setInputDate(request.getParameter("InputDate"));
//		System.out.println("Get Post "+param); 	
//		System.out.println(request.getRemoteAddr() + " / " + request.getHeader("X-Forwarded-For") + " / " + request.getHeader("Proxy-Client-IP") + " / " + request.getHeader("WL-Proxy-Client-IP") + " / " + request.getHeader("HTTP_CLIENT_IP") + " / " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
////		List<AppSayPlusMemInfoModel> result = appSayPlusMemInfoService.appSayPlusMemInfoList(param);
//		return appSayPlusMemInfoService.appSayPlusMemInfoList(param);
//		
//	}
	

//	/* 테스트 */
	@RequestMapping(value = "api/appSayPlusMemInfo/selectAppSayPlusMemInfoTest")
	public List<AppSayPlusMemInfoModel> appSayPlusMemInfoList()throws Exception {
		//http://211.169.222.2:24393/api/appSayPlusMemInfo/selectAppSayPlusMemInfoTest
		AppSayPlusMemInfoParamModel param = new AppSayPlusMemInfoParamModel();
		param.setCitizenNo1("830303");
		param.setMemName("arin");
		param.setHpNo("01043837663");
//		param.setCitizenNo1("910715");
//		param.setMemName("chen");
//		param.setHpNo("01065326366");
		
		System.out.println("Test "+param); 					//로그 찍기
//		System.out.println(request.getRemoteAddr() + " / " + request.getHeader("X-Forwarded-For") + " / " + request.getHeader("Proxy-Client-IP") + " / " + request.getHeader("WL-Proxy-Client-IP") + " / " + request.getHeader("HTTP_CLIENT_IP") + " / " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return appSayPlusMemInfoService.appSayPlusMemInfoList(param);
	}

	// http://localhost:8000/api/appSayPlusMemInfo?CitizenNo1=841203&MemName=%ED%85%8C%EC%8A%A4%ED%8A%B8&HpNo=01095209724&InputDate=20201105

	@RequestMapping(value = "api/appSayPlusMemInfo/selectAppSayPlusMemInfoList")
	public List<AppSayPlusMemInfoModel> appSayPlusMemInfoList(@RequestBody AppSayPlusMemInfoParamModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
		System.out.println("List "+request); 	
//		System.out.println(request.getRemoteAddr() + " / " + request.getHeader("X-Forwarded-For") + " / " + request.getHeader("Proxy-Client-IP") + " / " + request.getHeader("WL-Proxy-Client-IP") + " / " + request.getHeader("HTTP_CLIENT_IP") + " / " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));   
		appSayPlusMemInfoService.appSayPlusMemInfoList(request);
		return appSayPlusMemInfoService.appSayPlusMemInfoList(request);
	}
	
	 // Excel Download
//	   @RequestMapping(value="api/appSayPlusMemInfo/downloadExcel")
//    public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
//       response.setContentType("application/vnd.ms-excel");
//       response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=appSayPlusMemInfo.xlsx");
//       
//       AppSayPlusMemInfoParamModel requestData = (AppSayPlusMemInfoParamModel) sayUtils.requestJson(request.getParameter("param"), AppSayPlusMemInfoParamModel.class);
//       System.out.println( "appSayPlusMemInfo.controller.excel" );
//        try {
//           
//           //데이터생성
//           List<AppSayPlusMemInfoModel> result = appSayPlusMemInfoService.appSayPlusMemInfoList(requestData);
//           //this/excel
//           //csv생성
//           ByteArrayInputStream in = AppSayPlusMemInfoExcelGenerator.customersToExcel(result);
//           //허공으로 
//           response.getOutputStream().write(in.readAllBytes());
//
//           //util//excel
////           ExportUtils.exportXLSX(response, "appSayPlusMemInfo", appSayPlusMemInfoList(requestData));
//           
//         } catch (IOException e) {
//             e.printStackTrace();
//         } catch (Exception e) {
//            
//             e.printStackTrace();
//         } 
//
//       return;
//     }
		
}