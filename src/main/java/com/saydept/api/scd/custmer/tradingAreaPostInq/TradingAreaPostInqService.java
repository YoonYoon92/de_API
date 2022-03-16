package com.saydept.api.scd.custmer.tradingAreaPostInq;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.scd.custmer.tradingAreaPostInq.model.TradingAreaPostInqModel;

	@Service
	public class TradingAreaPostInqService {

	@Autowired
	private TradingAreaPostInqMapper tradingAreaPostInqMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public TradingAreaPostInqModel selectTradingAreaPostInq(TradingAreaPostInqModel request)throws Exception {

	TradingAreaPostInqModel result = tradingAreaPostInqMapper.selectTradingAreaPostInq(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<TradingAreaPostInqModel> selectTradingAreaPostInqList(TradingAreaPostInqModel request)throws Exception {

	
		List<TradingAreaPostInqModel> result = tradingAreaPostInqMapper.selectTradingAreaPostInqList(request);
		return result;

	}
	
	public List<TradingAreaPostInqModel> tradingAreaCdList(TradingAreaPostInqModel request)throws Exception {

		List<TradingAreaPostInqModel> result = tradingAreaPostInqMapper.tradingAreaCdList(request);
		return result;

	}


}