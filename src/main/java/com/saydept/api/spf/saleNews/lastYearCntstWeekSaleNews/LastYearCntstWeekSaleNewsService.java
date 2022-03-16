package com.saydept.api.spf.saleNews.lastYearCntstWeekSaleNews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.lastYearCntstWeekSaleNews.model.LastYearCntstWeekSaleNewsModel;
import com.saydept.api.spf.saleNews.lastYearCntstWeekSaleNews.model.LastYearCntstWeekSaleNewsParamModel;
import com.saydept.utils.SayUtils;

	@Service
	public class LastYearCntstWeekSaleNewsService {

	@Autowired
	private LastYearCntstWeekSaleNewsMapper lastYearCntstWeekSaleNewsMapper;
	
	@Autowired
	private SayUtils sayUtils;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public LastYearCntstWeekSaleNewsParamModel selectLastYearCntstWeekSaleNews(LastYearCntstWeekSaleNewsParamModel request)throws Exception {

		//조회시작일 기준 d-6일 일자 생성
				request.setD6Day(sayUtils.getCusomDay(request.getStartDate(), -6 ));
				request.setD5Day(sayUtils.getCusomDay(request.getStartDate(), -5 ));
				request.setD4Day(sayUtils.getCusomDay(request.getStartDate(), -4 ));
				request.setD3Day(sayUtils.getCusomDay(request.getStartDate(), -3 ));
				request.setD2Day(sayUtils.getCusomDay(request.getStartDate(), -2 ));
				request.setD1Day(sayUtils.getCusomDay(request.getStartDate(), -1 ));				
				
				//조회시작일 전년일자  생성		
				request.setOldD6Day(sayUtils.getSameDayAsLastYear(request.getD6Day()));
				request.setOldD5Day(sayUtils.getSameDayAsLastYear(request.getD5Day()));
				request.setOldD4Day(sayUtils.getSameDayAsLastYear(request.getD4Day()));
				request.setOldD3Day(sayUtils.getSameDayAsLastYear(request.getD3Day()));
				request.setOldD2Day(sayUtils.getSameDayAsLastYear(request.getD2Day()));
				request.setOldD1Day(sayUtils.getSameDayAsLastYear(request.getD1Day()));
				request.setOldStartDate(sayUtils.getSameDayAsLastYear(request.getStartDate()));
				
				
				return request;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<LastYearCntstWeekSaleNewsModel> selectLastYearCntstWeekSaleNewsList(LastYearCntstWeekSaleNewsParamModel request)throws Exception {


		//조회시작일 기준 d-6일 일자 생성
		request.setD6Day(sayUtils.getCusomDay(request.getStartDate(), -6 ));
		request.setD5Day(sayUtils.getCusomDay(request.getStartDate(), -5 ));
		request.setD4Day(sayUtils.getCusomDay(request.getStartDate(), -4 ));
		request.setD3Day(sayUtils.getCusomDay(request.getStartDate(), -3 ));
		request.setD2Day(sayUtils.getCusomDay(request.getStartDate(), -2 ));
		request.setD1Day(sayUtils.getCusomDay(request.getStartDate(), -1 ));				
		
		//조회시작일 전년일자  생성		
		request.setOldD6Day(sayUtils.getSameDayAsLastYear(request.getD6Day()));
		request.setOldD5Day(sayUtils.getSameDayAsLastYear(request.getD5Day()));
		request.setOldD4Day(sayUtils.getSameDayAsLastYear(request.getD4Day()));
		request.setOldD3Day(sayUtils.getSameDayAsLastYear(request.getD3Day()));
		request.setOldD2Day(sayUtils.getSameDayAsLastYear(request.getD2Day()));
		request.setOldD1Day(sayUtils.getSameDayAsLastYear(request.getD1Day()));
		request.setOldStartDate(sayUtils.getSameDayAsLastYear(request.getStartDate()));
		
				
		List<LastYearCntstWeekSaleNewsModel> result = lastYearCntstWeekSaleNewsMapper.selectLastYearCntstWeekSaleNewsList(request);
		return result;

	}



}