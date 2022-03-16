package com.saydept.api.sda.sleManageCt.acntSleManageCt;

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

import com.saydept.api.sda.sleManageCt.acntSleManageCt.model.AcntSleManageCtModel;
import com.saydept.api.sda.sleManageCt.acntSleManageCt.model.AcntSleManageCtParamModel;
import com.saydept.utils.SayUtils;



@CrossOrigin(origins = "*")
@RestController
public class AcntSleManageCtController {
	
	@Autowired
	private AcntSleManageCtService acntSleManageCtService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/acntSleManageCt", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/acntSleManageCt/selectAcntSleManageCtList")
	public List<AcntSleManageCtModel> acntSleManageCtList(@RequestBody AcntSleManageCtParamModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		request.setJum("01");
		
		return acntSleManageCtService.acntSleManageCtList(request);
	}

	 // Excel Download
	// http://localhost:8000/api/acntSleManageCt/downloadExcel?param=%7B"frDate":"20210101","toDate":"20211231","jum":"01","onlineChk":"430"%7D
	   @RequestMapping(value="api/acntSleManageCt/downloadExcel")
	   public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/vnd.ms-excel");
    response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=acntSleManageCt.xlsx");
    
    System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
    System.out.println((char)27+"[0;36m     "+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")+" param?"+request.getParameter("param")+(char)27+"[0;00m");
//    System.out.println(request.getParameter("param"));

    AcntSleManageCtParamModel requestData = (AcntSleManageCtParamModel) sayUtils.requestJson(request.getParameter("param"), AcntSleManageCtParamModel.class);
     try {
        
        //데이터생성
        List<AcntSleManageCtModel> result = acntSleManageCtService.acntSleManageCtList(requestData);
        //this/excel
        //csv생성
        ByteArrayInputStream in = AcntSleManageCtExcelGenerator.customersToExcel(result);
        //허공으로 
        response.getOutputStream().write(in.readAllBytes());

        //util//excel
//        ExportUtils.exportXLSX(response, "acntSleManageCt", acntSleManageCtList(requestData));
        
      } catch (IOException e) {
          e.printStackTrace();
      } catch (Exception e) {
         
          e.printStackTrace();
      } 

    return;
  }

	/* 테스트 */

//	@RequestMapping(value = "api/spf/saleNews/AcntSleManageCttest")
//	public List<AcntSleManageCtModel> acntSleManageCtList()throws Exception {
//		System.out.println("clssalenewscontroll_test");
//		AcntSleManageCtParamModel param = new AcntSleManageCtParamModel();
//		param.setJum("01");
//		param.setBu("0171");
//		param.setTim("017172");
////		param.setPc("76");
//		param.setSerchLevel("jum");
//		param.setFrDate("20200603");
//		param.setOnlineChk("A");
//		
////		List<AcntSleManageCtModel> result = acntSleManageCtService.acntSleManageCtList(param);
//		
//		return acntSleManageCtService.acntSleManageCtList(param);
//	}
	

}