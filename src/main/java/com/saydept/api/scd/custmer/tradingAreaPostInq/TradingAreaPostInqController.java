package com.saydept.api.scd.custmer.tradingAreaPostInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.scd.custmer.tradingAreaPostInq.model.TradingAreaPostInqModel;

@CrossOrigin(origins = "*")
@RestController
public class TradingAreaPostInqController {

	@Autowired
	private TradingAreaPostInqService tradingAreaPostInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/tradingAreaPostInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectTradingAreaPostInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/tradingAreaPostInq/selectTradingAreaPostInq", method = RequestMethod.POST)
	public TradingAreaPostInqModel selectTradingAreaPostInq(@RequestBody TradingAreaPostInqModel request)throws Exception {

		TradingAreaPostInqModel result = tradingAreaPostInqService.selectTradingAreaPostInq(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectTradingAreaPostInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/tradingAreaPostInq/selectTradingAreaPostInqList", method = RequestMethod.POST)
	public List<TradingAreaPostInqModel> selectTradingAreaPostInqList(@RequestBody TradingAreaPostInqModel request)throws Exception {

		List<TradingAreaPostInqModel> result = tradingAreaPostInqService.selectTradingAreaPostInqList(request);
		return result;
	}
	
	//상권 구분리스트 불러오기
	@RequestMapping(value = "api/tradingAreaPostInq/tradingAreaCdList", method = RequestMethod.POST)
	public List<TradingAreaPostInqModel> tradingAreaCdList(@RequestBody TradingAreaPostInqModel request)throws Exception {

		List<TradingAreaPostInqModel> result = tradingAreaPostInqService.tradingAreaCdList(request);
		return result;
	}

	

}