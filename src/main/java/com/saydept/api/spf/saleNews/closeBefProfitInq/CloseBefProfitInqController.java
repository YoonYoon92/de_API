package com.saydept.api.spf.saleNews.closeBefProfitInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.saleNews.closeBefProfitInq.model.CloseBefProfitInqModel;
import com.saydept.api.spf.saleNews.closeBefProfitInq.model.CloseBefProfitInqParamModel;


@CrossOrigin(origins = "*")
@RestController
public class CloseBefProfitInqController {

	@Autowired
	private CloseBefProfitInqService closeBefProfitInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/closeBefProfitInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectCloseBefProfitInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/closeBefProfitInq/selectCloseBefProfitInqList", method = RequestMethod.POST)
	public List<CloseBefProfitInqModel> selectCloseBefProfitInqList(@RequestBody CloseBefProfitInqParamModel request)throws Exception {
//		request.setJum("01");
//		request.setBu("71");
//		request.setTim("71");
//		request.setFromDate("20200201");
//		request.setToDate("20200410");		
//		request.setPc("51");
		System.out.println(request);
		
		List<CloseBefProfitInqModel> result = closeBefProfitInqService.selectCloseBefProfitInqList(request);
		return result;
	}


	
	
	//test
	@RequestMapping(value = "api/closeBefProfitInq/selectCloseBefProfitInqListTest")
	public List<CloseBefProfitInqModel> selectCloseBefProfitInqList()throws Exception {

		CloseBefProfitInqParamModel testparm = new CloseBefProfitInqParamModel();

		testparm.setJum("01");
		testparm.setBu("71");
		testparm.setTim("71");
		testparm.setFromDate("20200201");
		testparm.setToDate("20200410");		
		testparm.setPc("51");
//		testparm.setClass1("10203");
//		testparm.setClass2("01");							
		
		
		List<CloseBefProfitInqModel> result = closeBefProfitInqService.selectCloseBefProfitInqListTest(testparm);
		return result;
	}	
	
	
	
}
