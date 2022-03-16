package com.saydept.api.spf.goods.marginExchangeInq;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.goods.clsInq.model.ClsInqModel;
import com.saydept.api.spf.goods.marginExchangeInq.model.MarginExchangeInqModel;

	@Service
	public class MarginExchangeInqService {

	@Autowired
	private MarginExchangeInqMapper marginExchangeInqMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public MarginExchangeInqModel selectMarginExchangeInq(MarginExchangeInqModel request)throws Exception {

	MarginExchangeInqModel result = marginExchangeInqMapper.selectMarginExchangeInq(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<MarginExchangeInqModel> selectMarginExchangeInqList(MarginExchangeInqModel request)throws Exception {

		List<MarginExchangeInqModel> result = marginExchangeInqMapper.selectMarginExchangeInqList(request);
		return result;

	}

	//클래스목록
		public List<MarginExchangeInqModel> selectConerList(MarginExchangeInqModel request)throws Exception {

				List<MarginExchangeInqModel> result = marginExchangeInqMapper.selectConerList(request);
				System.out.println(request);
				System.out.println(result);
				return result;

			}

}