package com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq;
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

import com.saydept.api.spf.saleNews.clsPlnNetSaleSlt.ClsPlnNetSaleSltExcelGenerator;
import com.saydept.api.spf.saleNews.clsPlnNetSaleSlt.model.ClsPlnNetSaleSltModel;
import com.saydept.api.spf.saleNews.clsPlnNetSaleSlt.model.ClsPlnNetSaleSltParamModel;
import com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq.model.PcLastYearCntstIncrsrateInqModel;
import com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq.model.PcLastYearCntstIncrsrateInqParamModel;
import com.saydept.utils.SayUtils;

@CrossOrigin(origins = "*")
@RestController
public class PcLastYearCntstIncrsrateInqController {

	@Autowired
	private PcLastYearCntstIncrsrateInqService PCLastYearCntstIncrsrateInqService;
	private SayUtils sayUtils;
	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/pcLastYearCntstIncrsrateInq", method = RequestMethod.GET)
	public String condition() throws ParseException {
		System.out.println( new SayUtils().getCusomYear("20200605", -1) );
		
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectPCLastYearCntstIncrsrateInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/pcLastYearCntstIncrsrateInq/selectPcLastYearCntstIncrsrateInqList")
	public List<PcLastYearCntstIncrsrateInqModel> PCLastYearCntstIncrsrateInqList(@RequestBody PcLastYearCntstIncrsrateInqParamModel request)throws Exception {
		
		return PCLastYearCntstIncrsrateInqService.PCLastYearCntstIncrsrateInqList(request);
	}
	
	
	
	
	@RequestMapping(value = "api/pcLastYearCntstIncrsrateInq/TEST")
	public List<PcLastYearCntstIncrsrateInqModel> TEST()throws Exception {
		PcLastYearCntstIncrsrateInqParamModel result = new PcLastYearCntstIncrsrateInqParamModel();
		result.setTim("017171");
		result.setStartDt("20200601");
		result.setEndDt("20200610");
		
		return PCLastYearCntstIncrsrateInqService.PCLastYearCntstIncrsrateInqList(result);
	}

	
	@RequestMapping(value = "api/pcLastYearCntstIncrsrateInq/selectzoneStoreList")
	public List<PcLastYearCntstIncrsrateInqParamModel> selectzoneStoreList(@RequestBody PcLastYearCntstIncrsrateInqParamModel request)throws Exception {
		
		return PCLastYearCntstIncrsrateInqService.selectzoneStoreList(request);
	}
	
	// Excel Download
	@RequestMapping(value="api/pcLastYearCntstIncrsrateInq/downloadExcel")
	  public void progListExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/vnd.ms-excel");
  
    response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=pcLastYearCntstIncrsrateInq.xlsx");
  
    PcLastYearCntstIncrsrateInqParamModel requestData = (PcLastYearCntstIncrsrateInqParamModel) sayUtils.requestJson(request.getParameter("param"), PcLastYearCntstIncrsrateInqParamModel.class);

     try {
        
        //데이터생성
        List<PcLastYearCntstIncrsrateInqModel> result = PCLastYearCntstIncrsrateInqService.PCLastYearCntstIncrsrateInqList(requestData);
        //this/excel
        //csv생성
        ByteArrayInputStream in = PcLastYearCntstIncrsrateInqExcelGenerator.toExcel(result);
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