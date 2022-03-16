package com.saydept.api.scd.custmer.tradingAreaMemberInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.scd.custmer.tradingAreaMemberInq.model.TradingAreaMemberInqModel;

@CrossOrigin(origins = "*")
@RestController
public class TradingAreaMemberInqController {

	@Autowired
	private TradingAreaMemberInqService tradingAreaMemberInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/tradingAreaMemberInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectTradingAreaMemberInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/tradingAreaMemberInq/selectTradingAreaMemberInq", method = RequestMethod.POST)
	public TradingAreaMemberInqModel selectTradingAreaMemberInq(@RequestBody TradingAreaMemberInqModel request)throws Exception {

		TradingAreaMemberInqModel result = tradingAreaMemberInqService.selectTradingAreaMemberInq(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectTradingAreaMemberInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/tradingAreaMemberInq/selectTradingAreaMemberInqList", method = RequestMethod.POST)
	public List<TradingAreaMemberInqModel> selectTradingAreaMemberInqList(@RequestBody TradingAreaMemberInqModel request)throws Exception {

		List<TradingAreaMemberInqModel> result = tradingAreaMemberInqService.selectTradingAreaMemberInqList(request);
		return result;
	}
	@RequestMapping(value = "api/tradingAreaMemberInq/tradingAreaCdList", method = RequestMethod.POST)
	public List<TradingAreaMemberInqModel> tradingAreaCdList(@RequestBody TradingAreaMemberInqModel request)throws Exception {

		List<TradingAreaMemberInqModel> result = tradingAreaMemberInqService.tradingAreaCdList(request);
		return result;
	}
	@RequestMapping(value = "api/tradingAreaMemberInq/areaCdList", method = RequestMethod.POST)
	public List<TradingAreaMemberInqModel> areaCdList(@RequestBody TradingAreaMemberInqModel request)throws Exception {

		List<TradingAreaMemberInqModel> result = tradingAreaMemberInqService.areaCdList(request);
		return result;
	}
	

}