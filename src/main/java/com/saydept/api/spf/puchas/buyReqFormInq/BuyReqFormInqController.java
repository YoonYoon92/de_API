package com.saydept.api.spf.puchas.buyReqFormInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.puchas.buyReqFormInq.model.BuyReqFormInqModel;

@CrossOrigin(origins = "*")
@RestController
public class BuyReqFormInqController {

	@Autowired
	private BuyReqFormInqService buyReqFormInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/buyReqFormInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectBuyReqFormInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/buyReqFormInq/selectBuyReqFormInqList", method = RequestMethod.POST)
	public List<BuyReqFormInqModel> selectBuyReqFormInqList(@RequestBody BuyReqFormInqModel request)throws Exception {

		List<BuyReqFormInqModel> result = buyReqFormInqService.selectBuyReqFormInqList(request);
		return result;
	}
	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectBuyReqFormInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/buyReqFormInq/selectDetailList", method = RequestMethod.POST)
	public List<BuyReqFormInqModel> selectDetailList(@RequestBody BuyReqFormInqModel request)throws Exception {

		List<BuyReqFormInqModel> result = buyReqFormInqService.selectDetailList(request);
		return result;
	}


}