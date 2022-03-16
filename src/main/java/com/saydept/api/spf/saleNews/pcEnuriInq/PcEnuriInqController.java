package com.saydept.api.spf.saleNews.pcEnuriInq;

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

//import com.saydept.api.spf.goods.regiMasterSendInq.model.RegiMasterSendInqSearchModel;
import com.saydept.api.spf.saleNews.pcEnuriInq.model.PcEnuriInqModel;
import com.saydept.api.spf.saleNews.pcEnuriInq.model.PcEnuriInqParamModel;
import com.saydept.api.spf.saleNews.pcEnuriInq.model.PcEnuriInqSearchModel;
//import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

@CrossOrigin(origins = "*")
@RestController
public class PcEnuriInqController {
	
	@Autowired
	private PcEnuriInqService pcEnuriInqService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/pcEnuriInq", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/pcEnuriInq/selectPcEnuriInqList")
	public List<PcEnuriInqModel> pcEnuriInqList(@RequestBody PcEnuriInqParamModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
   
//		pcEnuriInqService.pcEnuriInqList(request);
		return pcEnuriInqService.pcEnuriInqList(request);
	}
	//포스
	@RequestMapping(value = "api/pcEnuriInq/selectPcEnuriInqSearchList")
	public List<PcEnuriInqSearchModel> PcEnuriInqRegiList(@RequestBody PcEnuriInqSearchModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
//		System.out.println(request); 					//로그 찍기
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
   
//		regiMasterSendInqService.regiMasterSendInqSearchList(request);
		return pcEnuriInqService.pcEnuriInqSearchList(request);
	}

	//코드
	@RequestMapping(value = "api/pcEnuriInq/selectPcEnuriInqSearchList2")
	public List<PcEnuriInqSearchModel> PcEnuriInqCdList(@RequestBody PcEnuriInqSearchModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
//		System.out.println(request); 					//로그 찍기
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
   
//		regiMasterSendInqService.regiMasterSendInqSearchList(request);
		return pcEnuriInqService.pcEnuriInqSearchList2(request);
	}

	 // Excel Download
	   @RequestMapping(value="api/pcEnuriInq/downloadExcel")
    public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.setContentType("application/vnd.ms-excel");
       response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=pcEnuriInq.xlsx");
       
       PcEnuriInqParamModel requestData = (PcEnuriInqParamModel) sayUtils.requestJson(request.getParameter("param"), PcEnuriInqParamModel.class);
       System.out.println( "pcEnuriInq.controller.excel" );
        try {
           
           //데이터생성
           List<PcEnuriInqModel> result = pcEnuriInqService.pcEnuriInqList(requestData);
           //this/excel
           //csv생성
           ByteArrayInputStream in = PcEnuriInqExcelGenerator.customersToExcel(result);
           //허공으로 
           response.getOutputStream().write(in.readAllBytes());

           //util//excel
//           ExportUtils.exportXLSX(response, "pcEnuriInq", pcEnuriInqList(requestData));
           
         } catch (IOException e) {
             e.printStackTrace();
         } catch (Exception e) {
            
             e.printStackTrace();
         } 

       return;
     }

	/* 테스트 */
	@RequestMapping(value = "api/spf/saleNews/PcEnuriInqtest")
	public List<PcEnuriInqModel> pcEnuriInqList()throws Exception {

		PcEnuriInqParamModel param = new PcEnuriInqParamModel();
		param.setJum("01");
		param.setBu("0171");
		param.setTim("017171");
//		param.setPc("01717176");
		param.setSerchLevel("jum");
		param.setFrDate("20200603");
		param.setToDate("20200604");
		param.setFrDateLy("20190603");
		param.setToDateLy("20190604");
		
//		List<PcEnuriInqModel> result = pcEnuriInqService.pcEnuriInqList(param);
		
		return pcEnuriInqService.pcEnuriInqList(param);
	}
	

}