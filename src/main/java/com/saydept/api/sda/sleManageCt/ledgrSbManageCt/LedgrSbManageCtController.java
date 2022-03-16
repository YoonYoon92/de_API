package com.saydept.api.sda.sleManageCt.ledgrSbManageCt;

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

import com.saydept.api.sda.sleManageCt.ledgrSbManageCt.model.LedgrSbManageCtModel;
import com.saydept.api.sda.sleManageCt.ledgrSbManageCt.model.LedgrSbManageCtParamModel;
import com.saydept.utils.SayUtils;



@CrossOrigin(origins = "*")
@RestController
public class LedgrSbManageCtController {
	
	@Autowired
	private LedgrSbManageCtService ledgrSbManageCtService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/ledgrSbManageCt", method = RequestMethod.GET)
	public String condition() throws ParseException {
//		System.out.println( new SayUtils().getCusomYear("20200603", -1) );
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
	@RequestMapping(value = "api/ledgrSbManageCt/selectLedgrSbManageCtList")
	public List<LedgrSbManageCtModel> ledgrSbManageCtList(@RequestBody LedgrSbManageCtParamModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		request.setJum("01");
		
		return ledgrSbManageCtService.ledgrSbManageCtList(request);
	}

	 // Excel Download
	// http://localhost:8000/api/ledgrSbManageCt/downloadExcel?param=%7B"frDate":"20210101","toDate":"20211231","jum":"01","onlineChk":"430"%7D
	   @RequestMapping(value="api/ledgrSbManageCt/downloadExcel")
	   public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/vnd.ms-excel");
    response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ledgrSbManageCt.xlsx");
    
    System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
    System.out.println((char)27+"[0;36m     "+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")+" param?"+request.getParameter("param")+(char)27+"[0;00m");
//    System.out.println(request.getParameter("param"));

    LedgrSbManageCtParamModel requestData = (LedgrSbManageCtParamModel) sayUtils.requestJson(request.getParameter("param"), LedgrSbManageCtParamModel.class);
     try {
        
        //데이터생성
        List<LedgrSbManageCtModel> result = ledgrSbManageCtService.ledgrSbManageCtList(requestData);
        //this/excel
        //csv생성
        ByteArrayInputStream in = LedgrSbManageCtExcelGenerator.customersToExcel(result);
        //허공으로 
        response.getOutputStream().write(in.readAllBytes());

        //util//excel
//        ExportUtils.exportXLSX(response, "ledgrSbManageCt", ledgrSbManageCtList(requestData));
        
      } catch (IOException e) {
          e.printStackTrace();
      } catch (Exception e) {
         
          e.printStackTrace();
      } 

    return;
  }

	/* 테스트 */

//	@RequestMapping(value = "api/spf/saleNews/LedgrSbManageCttest")
//	public List<LedgrSbManageCtModel> ledgrSbManageCtList()throws Exception {
//		System.out.println("clssalenewscontroll_test");
//		LedgrSbManageCtParamModel param = new LedgrSbManageCtParamModel();
//		param.setJum("01");
//		param.setBu("0171");
//		param.setTim("017172");
////		param.setPc("76");
//		param.setSerchLevel("jum");
//		param.setFrDate("20200603");
//		param.setOnlineChk("A");
//		
////		List<LedgrSbManageCtModel> result = ledgrSbManageCtService.ledgrSbManageCtList(param);
//		
//		return ledgrSbManageCtService.ledgrSbManageCtList(param);
//	}
	

}