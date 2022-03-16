package com.saydept.api.spf.saleNews.closeBefZoneSalePrint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.saleNews.closeBefZoneSalePrint.model.CloseBefZoneSalePrintModel;
import com.saydept.api.spf.saleNews.closeBefZoneSalePrint.model.CloseBefZoneSalePrintParamModel;


@CrossOrigin(origins = "*")
@RestController
public class CloseBefZoneSalePrintController {

	@Autowired
	private CloseBefZoneSalePrintService CloseBefZoneSalePrintService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/CloseBefZoneSalePrint", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectCloseBefZoneSalePrintList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/CloseBefZoneSalePrint/selectCloseBefZoneSalePrintList", method = RequestMethod.POST)
	public List<CloseBefZoneSalePrintModel> selectCloseBefZoneSalePrintList(@RequestBody CloseBefZoneSalePrintParamModel request)throws Exception {
//		request.setJum("01");
//		request.setBu("71");
//		request.setTim("71");
//		request.setFromDate("20200201");
//		request.setToDate("20200410");		
//		request.setPc("51");
		System.out.println(request);

		List<CloseBefZoneSalePrintModel> result = CloseBefZoneSalePrintService.selectCloseBefZoneSalePrintList(request);
		return result;
	}


	
	
	//test
	@RequestMapping(value = "api/CloseBefZoneSalePrint/selectCloseBefZoneSalePrintListTest")
	public List<CloseBefZoneSalePrintModel> selectCloseBefZoneSalePrintList()throws Exception {

		CloseBefZoneSalePrintParamModel testparm = new CloseBefZoneSalePrintParamModel();

		testparm.setJum("01");
		testparm.setBu("71");
		testparm.setTim("71");
		testparm.setFromDate("20200721");
		testparm.setToDate("20200820");		
		testparm.setPc("57");
//		testparm.setClass1("10203");
//		testparm.setClass2("01");							
		
		
		List<CloseBefZoneSalePrintModel> result = CloseBefZoneSalePrintService.selectCloseBefZoneSalePrintListTest(testparm);
		return result;
	}	
	
	
	
}
