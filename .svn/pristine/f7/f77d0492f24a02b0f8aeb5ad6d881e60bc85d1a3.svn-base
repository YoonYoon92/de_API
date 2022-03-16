package com.saydept.api.spf.saleNews.dayBestSaleInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.saleNews.dayBestSaleInq.model.DayBestSaleInqModel;
import com.saydept.api.spf.saleNews.dayBestSaleInq.model.DayBestSaleInqParamModel;

@CrossOrigin(origins = "*")
@RestController
public class DayBestSaleInqController {

	@Autowired
	private DayBestSaleInqService dayBestSaleInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/dayBestSaleInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 복수 대상 조회 
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectDayBestSaleInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/dayBestSaleInq/selectDayBestSaleInqList", method = RequestMethod.POST)
	public List<DayBestSaleInqModel> selectDayBestSaleInqList(@RequestBody DayBestSaleInqParamModel request)throws Exception {

		List<DayBestSaleInqModel> result = dayBestSaleInqService.selectDayBestSaleInqList(request);
		return result;
	}
	
	
	//test
	@RequestMapping(value = "api/dayBestSaleInq/selectDayBestSaleInqListTest")
	public List<DayBestSaleInqModel> selectDayBestSaleInqList()throws Exception {

		DayBestSaleInqParamModel testparm = new DayBestSaleInqParamModel();
		testparm.setSerchLevel("jum");
		testparm.setJum("01");
		
		List<DayBestSaleInqModel> result = dayBestSaleInqService.selectDayBestSaleInqList(testparm);
		return result;
	}


}