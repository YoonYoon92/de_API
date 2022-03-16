package com.saydept.api.spf.salePrice.salePriceChgReqFormInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.salePrice.salePriceChgReqFormInq.model.SalePriceChgReqFormInqModel;

@CrossOrigin(origins = "*")
@RestController
public class SalePriceChgReqFormInqController {

	@Autowired
	private SalePriceChgReqFormInqService salePriceChgReqFormInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/salePriceChgReqFormInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	
	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectSalePriceChgReqFormInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/salePriceChgReqFormInq/selectSalePriceChgReqFormInqList", method = RequestMethod.POST)
	public List<SalePriceChgReqFormInqModel> selectSalePriceChgReqFormInqList(@RequestBody SalePriceChgReqFormInqModel request)throws Exception {

		List<SalePriceChgReqFormInqModel> result = salePriceChgReqFormInqService.selectSalePriceChgReqFormInqList(request);
		return result;
	}
	@RequestMapping(value = "api/salePriceChgReqFormInq/selectDetailList", method = RequestMethod.POST)
	public List<SalePriceChgReqFormInqModel> selectDetailList(@RequestBody SalePriceChgReqFormInqModel request)throws Exception {

		List<SalePriceChgReqFormInqModel> result = salePriceChgReqFormInqService.selectDetailList(request);
		return result;
	}

}