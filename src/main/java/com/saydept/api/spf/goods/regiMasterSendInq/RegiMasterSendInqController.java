package com.saydept.api.spf.goods.regiMasterSendInq;

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

import com.saydept.api.spf.goods.regiMasterSendInq.model.RegiMasterSendInqModel;
import com.saydept.api.spf.goods.regiMasterSendInq.model.RegiMasterSendInqParamModel;
import com.saydept.api.spf.goods.regiMasterSendInq.model.RegiMasterSendInqSearchModel;
import com.saydept.utils.SayUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

@CrossOrigin(origins = "*")
@RestController
public class RegiMasterSendInqController {
	
	@Autowired
	private RegiMasterSendInqService regiMasterSendInqService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/regiMasterSendInq", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/regiMasterSendInq/selectRegiMasterSendInqList")
	public List<RegiMasterSendInqModel> regiMasterSendInqList(@RequestBody RegiMasterSendInqParamModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
//		System.out.println(request); 					//로그 찍기
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
   
//		regiMasterSendInqService.regiMasterSendInqList(request);
		return regiMasterSendInqService.regiMasterSendInqList(request);
	}
	
	@RequestMapping(value = "api/regiMasterSendInq/selectRegiMasterSendInqSearchList")
	public List<RegiMasterSendInqSearchModel> regiMasterSendInqRegiList(@RequestBody RegiMasterSendInqSearchModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
//		System.out.println(request); 					//로그 찍기
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
   
//		regiMasterSendInqService.regiMasterSendInqSearchList(request);
		return regiMasterSendInqService.regiMasterSendInqSearchList(request);
	}
	
	 // Excel Download
	   @RequestMapping(value="api/regiMasterSendInq/downloadExcel")
   public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.setContentType("application/vnd.ms-excel");
      response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=regiMasterSendInq.xlsx");
      
      RegiMasterSendInqParamModel requestData = (RegiMasterSendInqParamModel) sayUtils.requestJson(request.getParameter("param"), RegiMasterSendInqParamModel.class);
      System.out.println( "regiMasterSendInq.controller.excel" );
       try {
          
          //데이터생성
          List<RegiMasterSendInqModel> result = regiMasterSendInqService.regiMasterSendInqList(requestData);
          //this/excel
          //csv생성
          ByteArrayInputStream in = RegiMasterSendInqExcelGenerator.customersToExcel(result);
          //허공으로 
          response.getOutputStream().write(in.readAllBytes());

          //util//excel
//          ExportUtils.exportXLSX(response, "regiMasterSendInq", regiMasterSendInqList(requestData));
          
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
           
            e.printStackTrace();
        } 

      return;
    }
	/* 테스트 */
	@RequestMapping(value = "api/spf/saleNews/RegiMasterSendInqtest")
	public List<RegiMasterSendInqModel> regiMasterSendInqList()throws Exception {

		RegiMasterSendInqParamModel param = new RegiMasterSendInqParamModel();
		
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
		
//		List<RegiMasterSendInqModel> result = regiMasterSendInqService.regiMasterSendInqList(param);
		System.out.println(param); 					//로그 찍기
		return regiMasterSendInqService.regiMasterSendInqList(param);
	}
	

}