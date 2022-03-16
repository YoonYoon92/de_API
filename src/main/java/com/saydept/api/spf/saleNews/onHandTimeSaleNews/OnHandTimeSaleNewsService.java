package com.saydept.api.spf.saleNews.onHandTimeSaleNews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.onHandTimeSaleNews.model.OnHandTimeSaleNewsModel;
import com.saydept.api.spf.saleNews.onHandTimeSaleNews.model.OnHandTimeSaleNewsParamModel;
import com.saydept.api.spf.saleNews.onHandTimeSaleNews.model.OnHandTimeSaleNewsTotalModel;

	@Service
	public class OnHandTimeSaleNewsService {

	@Autowired
	private OnHandTimeSaleNewsMapper onHandTimeSaleNewsMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OnHandTimeSaleNewsTotalModel selectOnHandTimeSaleNews(OnHandTimeSaleNewsParamModel request)throws Exception {

	OnHandTimeSaleNewsTotalModel result = onHandTimeSaleNewsMapper.selectOnHandTimeSaleNews(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<OnHandTimeSaleNewsModel> selectOnHandTimeSaleNewsList(OnHandTimeSaleNewsParamModel request)throws Exception {

		List<OnHandTimeSaleNewsModel> result = onHandTimeSaleNewsMapper.selectOnHandTimeSaleNewsList(request);
		return result;

	}

}