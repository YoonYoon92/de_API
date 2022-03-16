package com.saydept.api.spf.saleNews.closeBefZoneSalePrint;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.saleNews.closeBefZoneSalePrint.model.CloseBefZoneSalePrintModel;
import com.saydept.api.spf.saleNews.closeBefZoneSalePrint.model.CloseBefZoneSalePrintParamModel;
import com.saydept.utils.SayUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@CrossOrigin(origins = "*")
@RestController
public class CloseBefZoneSalePrintPDF {

	@Autowired
	private CloseBefZoneSalePrintService closeBefZoneSalePrintService;
	
	@Autowired
	private SayUtils sayUtils;


	//레포트
	@RequestMapping(value="api/closeBefZoneSalePrint/reportCloseBefZoneSalePrintList")
	public void progList(HttpServletRequest request, HttpServletResponse response) throws IOException, JRException{
	      
		response.setContentType("application/pdf");
		response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=jasper.pdf;");
	      
		//클라이언트에서 온 param(json 문자열을 api에서 사용할 model 객체로 변환한다
		CloseBefZoneSalePrintParamModel requestData = (CloseBefZoneSalePrintParamModel) sayUtils.requestJson(request.getParameter("param"), CloseBefZoneSalePrintParamModel.class);
						
		
		try {
			List<CloseBefZoneSalePrintModel> result = closeBefZoneSalePrintService.selectCloseBefZoneSalePrintList(requestData);	
			
			//PDF 생성
			//String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "report\\closeBefZoneSale\\closeBefZoneSale.jasper").getAbsolutePath();
			String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "report\\spf\\saleNews\\closeBefZoneSalePrint\\closeBefZoneSalePrint.jasper" + 
					"").getAbsolutePath();
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("fromDate", requestData.getFromDate());
			parameters.put("toDate", requestData.getToDate());
			parameters.put("pgmId", "closeBefZoneSalePrint");
			parameters.put("jumCd", result.get(0).getJum());
			parameters.put("buCd", result.get(0).getBu());
			parameters.put("timCd", result.get(0).getTim());
			parameters.put("jumName", result.get(0).getJumNm());
			if(requestData.getBu() != null && requestData.getBu() != "")
			{
				parameters.put("buName", result.get(0).getBuNm());
				if(requestData.getTim() != null && requestData.getTim() != "")
				{
					parameters.put("timName", result.get(0).getTimNm());
				}				
				else
				{
					parameters.put("timName", "");	
					parameters.put("timCd", "");
				}				
			}
			else
			{
				parameters.put("buName", "");
				parameters.put("buCd", "");
				parameters.put("timName", "");	
				parameters.put("timCd", "");
			}
			System.out.println(requestData);
			
						
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(result);
			
			//================================================================================================================================================================

			//================================================================================================================================================================	
			JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;

	}

//	//CSV 내보내기
//	@RequestMapping(value="api/report/csv")
//	   public void progListCsv(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		
//	      response.setContentType("text/csv");
//	      response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=customers.csv");
//	      
//	       CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(),CSVFormat.DEFAULT.withHeader("name", "color"));
//			//클라이언트에서 온 param(json 문자열을 api에서 사용할 model 객체로 변환한다
////			CloseBefZoneSalePrintParamModel requestData = (CloseBefZoneSalePrintParamModel) sayUtils.requestJson(request.getParameter("param"), CloseBefZoneSalePrintParamModel.class);
//						
//	       
//	       try {
//    	   //데이터 생성
////	    	   List<CloseBefZoneSalePrintModel> result = closeBefZoneSalePrintService.selectCloseBefZoneSalePrintList(requestData);	
//	          List<ReportModel> dataList = new ArrayList<ReportModel>();
//	         ReportModel reportModel = new ReportModel();
//	         reportModel.setName("ssof");
//	         reportModel.setColor("red");
//	         dataList.add(reportModel);
//	         
//	         for(int i = 0; i <= 10; i++) {
//	            reportModel = new ReportModel();
//	            reportModel.setName("ssof"+i);
//	            reportModel.setColor("red"+i);
//	            dataList.add(reportModel);
//	         }      
//	         
//	         //CSV 생성
//	          for (ReportModel node : dataList) {
//	              csvPrinter.printRecord(Arrays.asList(node.getName(), node.getColor()));
//	          }
//	          
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        } finally {
//	             if(csvPrinter != null) csvPrinter.close();
//	        }
//
//	      return;
//	    }		
	   //CSV소스************
    @RequestMapping(value="/api/CloseBefZoneSalePrint/csv")
       public void progListCsv(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
          response.setContentType("text/csv");
          response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=customers.csv");
       
          //프린터를 만들때 타이틀값을 준다 (여러개주고싶으면 여러개 작성)
          response.getWriter().write('\ufeff'); // \ufeff = 유니코드 시작바이트    
          CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(),CSVFormat.DEFAULT.withHeader("ZoneName", "netSale"));
          
          
          CloseBefZoneSalePrintParamModel requestData = (CloseBefZoneSalePrintParamModel) sayUtils.requestJson(request.getParameter("param"), CloseBefZoneSalePrintParamModel.class);
             
          
           try {      
        	 //데이터생성     
        	  List<CloseBefZoneSalePrintModel> result = closeBefZoneSalePrintService.selectCloseBefZoneSalePrintList(requestData);                  
             
             //csv생성
              for (CloseBefZoneSalePrintModel node : result) {
                  csvPrinter.printRecord(Arrays.asList(node.getZoneNm(), node.getYearNetsale()));
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
	
	 //Excel 내보내기
//	 @RequestMapping(value="api/report/excel")
//	   public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
//	      response.setContentType("application/vnd.ms-excel");
//	      response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=customers.xlsx");
//
//			//클라이언트에서 온 param(json 문자열을 api에서 사용할 model 객체로 변환한다
////			CloseBefZoneSalePrintParamModel requestData = (CloseBefZoneSalePrintParamModel) sayUtils.requestJson(request.getParameter("param"), CloseBefZoneSalePrintParamModel.class);
// 
//   	   	   //데이터 생성
////   	   List<CloseBefZoneSalePrintModel> result = closeBefZoneSalePrintService.selectCloseBefZoneSalePrintList(requestData);	      
//	      List<ReportModel> dataList = new ArrayList<ReportModel>();
//	      ReportModel reportModel = new ReportModel();
//	      reportModel.setName("ssof");
//	      reportModel.setColor("red");
//	      dataList.add(reportModel);
//	      
//	      for(int i = 0; i <= 10; i++) {
//	         reportModel = new ReportModel();
//	         reportModel.setName("ssof"+i);
//	         reportModel.setColor("red"+i);
//	         dataList.add(reportModel);
//	      }      
//	      
//	      
//	      //엑셀 파일 생성
//	      ByteArrayInputStream in = CloseBefZoneSalePrintExcelGenerator.toExcel(dataList);
//	       
//	      response.getOutputStream().write(in.readAllBytes());
//
//	      return;
//	    }
//	
  //엑셀소스**********
    @RequestMapping(value="/api/CloseBefZoneSalePrint/excel")
    public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.setContentType("application/vnd.ms-excel");
       response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=customers.xlsx");

       CloseBefZoneSalePrintParamModel requestData = (CloseBefZoneSalePrintParamModel) sayUtils.requestJson(request.getParameter("param"), CloseBefZoneSalePrintParamModel.class);
       
       
        try {
        	//데이터생성
        	List<CloseBefZoneSalePrintModel> result = closeBefZoneSalePrintService.selectCloseBefZoneSalePrintList(requestData);   
        	
        	//excel생성
        	ByteArrayInputStream in = CloseBefZoneSalePrintExcelGenerator.toExcel(result);
            //허공으로 
            response.getOutputStream().write(in.readAllBytes());

         } catch (IOException e) {
             e.printStackTrace();
         } catch (Exception e) {
            
             e.printStackTrace();
         } 
       
      

       return;
     }    
    
    
}
