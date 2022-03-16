package com.saydept.api.spf.saleNews.clsSaleNews;

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

import com.saydept.api.spf.saleNews.clsSaleNews.model.ClsSaleNewsModel;
import com.saydept.api.spf.saleNews.clsSaleNews.model.ClsSaleNewsParamModel;
import com.saydept.utils.SayUtils;



@CrossOrigin(origins = "*")
@RestController
public class ClsSaleNewsController {
	
	@Autowired
	private ClsSaleNewsService clsSaleNewsService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/clsSaleNews", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/clsSaleNews/selectClsSaleNewsList")
	public List<ClsSaleNewsModel> clsSaleNewsList(@RequestBody ClsSaleNewsParamModel request)throws Exception {
		System.out.println("Controller1");
		System.out.println(request); 					//로그 찍기
		request.setJum("01");
		//		clsSaleNewsService.clsSaleNewsList(request);
//		if(request.getOnlineChk().trim() == "A") {
			return clsSaleNewsService.clsSaleNewsListA(request);
	//	}
//		else
//		{
//			return clsSaleNewsService.clsSaleNewsListA(request);
//		}
		
		
	}

	 // Excel Download
	   @RequestMapping(value="api/clsSaleNews/downloadExcel")
	   public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/vnd.ms-excel");
    response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=clsSaleNews.xlsx");

    ClsSaleNewsParamModel requestData = (ClsSaleNewsParamModel) sayUtils.requestJson(request.getParameter("param"), ClsSaleNewsParamModel.class);
//    System.out.println( "clsSaleNews.controller.excel" );
     try {
        
        //데이터생성
        List<ClsSaleNewsModel> result = clsSaleNewsService.clsSaleNewsList(requestData);
        //this/excel
        //csv생성
        ByteArrayInputStream in = ClsSaleNewsExcelGenerator.customersToExcel(result);
        //허공으로 
        response.getOutputStream().write(in.readAllBytes());

        //util//excel
//        ExportUtils.exportXLSX(response, "clsSaleNews", clsSaleNewsList(requestData));
        
      } catch (IOException e) {
          e.printStackTrace();
      } catch (Exception e) {
         
          e.printStackTrace();
      } 

    return;
  }

	/* 테스트 */

	@RequestMapping(value = "api/spf/saleNews/ClsSaleNewstest")
	public List<ClsSaleNewsModel> clsSaleNewsList()throws Exception {
		System.out.println("clssalenewscontroll_test");
		ClsSaleNewsParamModel param = new ClsSaleNewsParamModel();
		param.setJum("01");
		param.setBu("0171");
		param.setTim("017172");
//		param.setPc("76");
		param.setSerchLevel("jum");
		param.setSearchDay("20200603");
		param.setOnlineChk("A");
		
//		List<ClsSaleNewsModel> result = clsSaleNewsService.clsSaleNewsList(param);
		
		return clsSaleNewsService.clsSaleNewsList(param);
	}
	

}