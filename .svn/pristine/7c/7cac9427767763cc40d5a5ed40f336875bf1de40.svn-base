package com.saydept.api.spf.saleNews.conerMmAvrageSaleInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.saleNews.conerMmAvrageSaleInq.model.ConerMmAvrageSaleInqModel;
import com.saydept.api.spf.saleNews.conerMmAvrageSaleInq.model.ConerMmAvrageSaleInqParamModel;


@CrossOrigin(origins = "*")
@RestController
public class ConerMmAvrageSaleInqController {

	@Autowired
	private ConerMmAvrageSaleInqService conerMmAvrageSaleInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/conerMmAvrageSaleInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}



	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectConerMmAvrageSaleInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerMmAvrageSaleInq/selectConerMmAvrageSaleInqList", method = RequestMethod.POST)
	public List<ConerMmAvrageSaleInqModel> selectConerMmAvrageSaleInqList(@RequestBody ConerMmAvrageSaleInqParamModel request)throws Exception {

		List<ConerMmAvrageSaleInqModel> result = conerMmAvrageSaleInqService.selectConerMmAvrageSaleInqList(request);
		return result;
	}

	
	
	//test
	@RequestMapping(value = "api/conerMmAvrageSaleInq/selectConerMmAvrageSaleInqListTest")
	public List<ConerMmAvrageSaleInqModel> selectConerMmAvrageSaleInqList()throws Exception {

		ConerMmAvrageSaleInqParamModel testparm = new ConerMmAvrageSaleInqParamModel();
		testparm.setSerchLevel("tim");
		testparm.setJum("01");
		testparm.setBu("0171");
		testparm.setTim("017171");
		testparm.setFrDate("20200401");
		testparm.setToDate("20200501");
													
//		testparm.setFrYYMM("202004");
//		testparm.setToYYMM("202005");
//		testparm.setMmCount(1);
//		testparm.setBu("71");
//		testparm.setTim("71");
		
		List<ConerMmAvrageSaleInqModel> result = conerMmAvrageSaleInqService.selectConerMmAvrageSaleInqList(testparm);
		return result;
	}
	

}