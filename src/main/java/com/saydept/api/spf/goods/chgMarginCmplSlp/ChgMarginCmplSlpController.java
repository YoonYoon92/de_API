package com.saydept.api.spf.goods.chgMarginCmplSlp;

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

import com.saydept.api.spf.goods.chgMarginCmplSlp.model.ChgMarginCmplSlpModel;
import com.saydept.api.spf.goods.chgMarginCmplSlp.model.ChgMarginCmplSlpParamModel;
//import com.saydept.api.spf.goods.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

@CrossOrigin(origins = "*")
@RestController
public class ChgMarginCmplSlpController {
	
	@Autowired
	private ChgMarginCmplSlpService chgMarginCmplSlpService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/chgMarginCmplSlp", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/chgMarginCmplSlp/selectChgMarginCmplSlpList")
	public List<ChgMarginCmplSlpModel> chgMarginCmplSlpList(@RequestBody ChgMarginCmplSlpParamModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
   
//		chgMarginCmplSlpService.chgMarginCmplSlpList(request);
		return chgMarginCmplSlpService.chgMarginCmplSlpList(request);
	}
	
	 // Excel Download
	   @RequestMapping(value="api/chgMarginCmplSlp/downloadExcel")
	   public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/vnd.ms-excel");
    response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=chgMarginCmplSlp.xlsx");
    
    ChgMarginCmplSlpParamModel requestData = (ChgMarginCmplSlpParamModel) sayUtils.requestJson(request.getParameter("param"), ChgMarginCmplSlpParamModel.class);
    System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
	System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
     try {
        
        //데이터생성
        List<ChgMarginCmplSlpModel> result = chgMarginCmplSlpService.chgMarginCmplSlpList(requestData);
        //this/excel
        //csv생성
        ByteArrayInputStream in = ChgMarginCmplSlpExcelGenerator.customersToExcel(result);
        //허공으로 
        response.getOutputStream().write(in.readAllBytes());

        //util//excel
//        ExportUtils.exportXLSX(response, "chgMarginCmplSlp", chgMarginCmplSlpList(requestData));
        
      } catch (IOException e) {
          e.printStackTrace();
      } catch (Exception e) {
         
          e.printStackTrace();
      } 

    return;
  }
	   

}