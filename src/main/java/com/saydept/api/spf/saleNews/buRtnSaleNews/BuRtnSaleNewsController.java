package com.saydept.api.spf.saleNews.buRtnSaleNews;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.saleNews.buRtnSaleNews.model.BuRtnSaleNewsModel;
import com.saydept.api.spf.saleNews.buRtnSaleNews.model.BuRtnSaleNewsParamModel;
import com.saydept.utils.ExportUtils;
import com.saydept.utils.SayUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@CrossOrigin(origins = "*")
@RestController
public class BuRtnSaleNewsController {
	
	@Autowired
	private BuRtnSaleNewsService buRtnSaleNewsService;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/buRtnSaleNews", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/buRtnSaleNews/selectBuRtnSaleNewsList")
	public List<BuRtnSaleNewsModel> buRtnSaleNewsList(@RequestBody BuRtnSaleNewsParamModel request)throws Exception {
//		System.out.println("Jum:"			.concat(request.getJum() 		== null ? "NULL" : request.getJum())); 					//로그에 문자열 붙여서 찍기
		buRtnSaleNewsService.buRtnSaleNewsList(request);
		return buRtnSaleNewsService.buRtnSaleNewsList(request);
	}
	/**
	 * 레포트 조회
	 */
	   //Pdf iframe
	   @RequestMapping(value="api/buRtnSaleNews/viewReport")
	   public void progList(HttpServletRequest request, HttpServletResponse response) throws IOException, JRException{
		   
	      //클라이언트에서 온 param(json 문자열을 api에서 사용할 model 객체로 변환한다

		   BuRtnSaleNewsParamModel requestData = (BuRtnSaleNewsParamModel) sayUtils.requestJson(request.getParameter("param"), BuRtnSaleNewsParamModel.class);
	      try {
	    	  System.out.println("control.try");
	    	 List<BuRtnSaleNewsModel> result = buRtnSaleNewsService.buRtnSaleNewsList(requestData);
	         
	         Map<String, Object> parameters = new HashMap<String, Object>();
	         
	         //파라메터 설정
	         parameters.put("pgmId", "buRtnSaleNews");
	         parameters.put("frDate", requestData.getSearchDay().substring(0,4) + "/"
		                			+ requestData.getSearchDay().substring(4,6) + "/"
		                			+ requestData.getSearchDay().substring(6,8) );
	         parameters.put("toDate", requestData.getSearchDayTo().substring(0,4) + "/"
		                			+ requestData.getSearchDayTo().substring(4,6) + "/"
		                			+ requestData.getSearchDayTo().substring(6,8) );
	         parameters.put("sabun", "sabun");
	         parameters.put("userName", "userName");

//	     	private String frDate;          //시작검색일자
//	    	private String toDate;          //종료검색일자
	         
	         //this/jasper
//															C:\SayAPI\workspace\SAY_API\bin\main\report\buRtnSaleNews\buRtnSaleNews.jasper
//	         String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "report\\buRtnSaleNews\\buRtnSaleNews.jasper").getAbsolutePath();
//
//	         JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(result);
//	         //================================================================================================================================================================
//	         response.setContentType("application/pdf");
//	         response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
//	         //================================================================================================================================================================
//	         JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
//	         JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	         
	         //util/jasper
//	         ExportUtils.exportPDF(response, "buRtnSaleNews", "report\\buRtnSaleNews\\buRtnSaleNews.jasper", parameters, buRtnSaleNewsList(requestData));
	         ExportUtils.exportPDF(response, "buRtnSaleNews_" + requestData.getSearchDay() + "-" + requestData.getSearchDayTo(), "report\\spf\\saleNews\\buRtnSaleNews\\buRtnSaleNews.jasper", parameters, buRtnSaleNewsList(requestData));
	         
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      return;

	   }

	   // Csv Download
	   @RequestMapping(value="api/buRtnSaleNews/downloadCsv")
	   public void progListCsv(HttpServletRequest request, HttpServletResponse response) throws IOException {
	      response.setContentType("text/csv");
	      response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=buRtnSaleNews.csv");
	      //유니코드
	      response.getWriter().write('\ufeff');
	      //헤더생성, 여러줄도 가능
	       CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(),CSVFormat.DEFAULT.withHeader("name", "color"));

	       BuRtnSaleNewsParamModel requestData = (BuRtnSaleNewsParamModel) sayUtils.requestJson(request.getParameter("param"), BuRtnSaleNewsParamModel.class);
	          
           try {
              List<BuRtnSaleNewsModel> result = buRtnSaleNewsService.buRtnSaleNewsList(requestData);
              //데이터생성
             
             //csv생성
              for (BuRtnSaleNewsModel node : result) {
                  csvPrinter.printRecord(Arrays.asList(node.getCls(), node.getClsNm()));
              }
              
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
               
                e.printStackTrace();
            } finally {
                 if(csvPrinter != null) csvPrinter.close();
            }

          return;
        }
	   
	 // Excel Download
	   @RequestMapping(value="api/buRtnSaleNews/downloadExcel")
       public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
          response.setContentType("application/vnd.ms-excel");
          response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=buRtnSaleNews.xlsx");
          
          BuRtnSaleNewsParamModel requestData = (BuRtnSaleNewsParamModel) sayUtils.requestJson(request.getParameter("param"), BuRtnSaleNewsParamModel.class);
          System.out.println( "buRtnSaleNews.controller.excel" );
           try {
              
              //데이터생성
              List<BuRtnSaleNewsModel> result = buRtnSaleNewsService.buRtnSaleNewsList(requestData);
              //this/excel
              //csv생성
              ByteArrayInputStream in = BuRtnSaleNewsExcelGenerator.customersToExcel(result);
              //허공으로 
              response.getOutputStream().write(in.readAllBytes());

              //util//excel
//              ExportUtils.exportXLSX(response, "buRtnSaleNews", buRtnSaleNewsList(requestData));
              
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
               
                e.printStackTrace();
            } 

          return;
        }
	             
	/* 테스트 */
	@RequestMapping(value = "api/spf/saleNews/BuRtnSaleNewstest")
	public List<BuRtnSaleNewsModel> buRtnSaleNewsList()throws Exception {

		BuRtnSaleNewsParamModel param = new BuRtnSaleNewsParamModel();
		param.setJum("01");
		param.setBu("0171");
		param.setTim("017171");
//		param.setPc("01717176");
		param.setSerchLevel("tim");
		param.setSearchDay("20200601");
		param.setSearchDayTo("20200631");
		
//		List<BuRtnSaleNewsModel> result = buRtnSaleNewsService.buRtnSaleNewsList(param);
		
		return buRtnSaleNewsService.buRtnSaleNewsList(param);
	}
	

}