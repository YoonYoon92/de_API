package com.saydept.api.spf.saleNews.buPlanSaleInq;

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


import com.saydept.api.spf.saleNews.buPlanSaleInq.model.BuPlanSaleInqModel;
import com.saydept.api.spf.saleNews.buPlanSaleInq.model.BuPlanSaleInqParamModel;
import com.saydept.utils.SayUtils;

@CrossOrigin(origins = "*")
@RestController
public class BuPlanSaleInqController {

	@Autowired
	private BuPlanSaleInqService buPlanSaleInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/buPlanSaleInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	@RequestMapping(value = "/api/buPlanSaleInq/selectBuPlanSaleInqList")
	public List<BuPlanSaleInqModel> selectBuPlanSaleInqList(@RequestBody BuPlanSaleInqParamModel request)throws Exception {
		
		return buPlanSaleInqService.selectBuPlanSaleInqList(request);
	}
	
	@RequestMapping(value = "api/BuPlanSaleInqModel/TEST")
	
	public List<BuPlanSaleInqModel> TEST()throws Exception {
		BuPlanSaleInqParamModel result = new BuPlanSaleInqParamModel();
		result.setJum("01");
		result.setStartDt("20200601");
		result.setEndDt("20200601");
		

		return buPlanSaleInqService.selectBuPlanSaleInqList(result);
	}
	
}