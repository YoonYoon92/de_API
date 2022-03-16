package com.saydept.api.spf.saleNews.weekTimeSaleNews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsOrgModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

	@Service
	public class WeekTimeSaleNewsService {

	@Autowired
	private WeekTimeSaleNewsMapper weekTimeSaleNewsMapper;
	
	@Autowired
	private SayUtils sayUtils;
	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public WeekTimeSaleNewsParamModel selectWeekTimeSaleNewsDate(WeekTimeSaleNewsParamModel request)throws Exception {
        
		if ( request.getSelectVal().equals("1") ) {
			//조회시작일 기준 d-6일 일자 생성
			request.setD6Day(sayUtils.getCusomDay(request.getStartDate(), -6 ));
			request.setD5Day(sayUtils.getCusomDay(request.getStartDate(), -5 ));
			request.setD4Day(sayUtils.getCusomDay(request.getStartDate(), -4 ));
			request.setD3Day(sayUtils.getCusomDay(request.getStartDate(), -3 ));
			request.setD2Day(sayUtils.getCusomDay(request.getStartDate(), -2 ));
			request.setD1Day(sayUtils.getCusomDay(request.getStartDate(), -1 ));					
		} else {
			//조회시작일 기준 전 동요일 일자 생성
			request.setD6Day(sayUtils.getCusomDay(request.getStartDate(), -42 ));
			request.setD5Day(sayUtils.getCusomDay(request.getStartDate(), -35 ));
			request.setD4Day(sayUtils.getCusomDay(request.getStartDate(), -28 ));
			request.setD3Day(sayUtils.getCusomDay(request.getStartDate(), -21 ));
			request.setD2Day(sayUtils.getCusomDay(request.getStartDate(), -14 ));
			request.setD1Day(sayUtils.getCusomDay(request.getStartDate(), -7 ));
		}
		
		//조회시작일 전년일자  생성
		request.setOldStartDate(sayUtils.getCusomYear(request.getStartDate(), -1 ));
		request.setOldD6Day(sayUtils.getCusomYear(request.getD6Day(), -1 ));
		request.setOldD5Day(sayUtils.getCusomYear(request.getD5Day(), -1 ));
		request.setOldD4Day(sayUtils.getCusomYear(request.getD4Day(), -1 ));
		request.setOldD3Day(sayUtils.getCusomYear(request.getD3Day(), -1 ));
		request.setOldD2Day(sayUtils.getCusomYear(request.getD2Day(), -1 ));
		request.setOldD1Day(sayUtils.getCusomYear(request.getD1Day(), -1 ));
		
	return request;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<WeekTimeSaleNewsModel> selectWeekTimeSaleNewsList(WeekTimeSaleNewsParamModel request) throws Exception {
		
		if ( request.getSelectVal().equals("1") ) {
			//조회시작일 기준 d-6일 일자 생성
			request.setD6Day(sayUtils.getCusomDay(request.getStartDate(), -6 ));
			request.setD5Day(sayUtils.getCusomDay(request.getStartDate(), -5 ));
			request.setD4Day(sayUtils.getCusomDay(request.getStartDate(), -4 ));
			request.setD3Day(sayUtils.getCusomDay(request.getStartDate(), -3 ));
			request.setD2Day(sayUtils.getCusomDay(request.getStartDate(), -2 ));
			request.setD1Day(sayUtils.getCusomDay(request.getStartDate(), -1 ));				
		} else {
			//조회시작일 기준 전 동요일 일자 생성
			request.setD6Day(sayUtils.getCusomDay(request.getStartDate(), -42 ));
			request.setD5Day(sayUtils.getCusomDay(request.getStartDate(), -35 ));
			request.setD4Day(sayUtils.getCusomDay(request.getStartDate(), -28 ));
			request.setD3Day(sayUtils.getCusomDay(request.getStartDate(), -21 ));
			request.setD2Day(sayUtils.getCusomDay(request.getStartDate(), -14 ));
			request.setD1Day(sayUtils.getCusomDay(request.getStartDate(), -7 ));		
		}
		
		//조회시작일 전년일자  생성
		request.setOldStartDate(sayUtils.getCusomYear(request.getStartDate(), -1 ));
		request.setOldD6Day(sayUtils.getCusomYear(request.getD6Day(), -1 ));
		request.setOldD5Day(sayUtils.getCusomYear(request.getD5Day(), -1 ));
		request.setOldD4Day(sayUtils.getCusomYear(request.getD4Day(), -1 ));
		request.setOldD3Day(sayUtils.getCusomYear(request.getD3Day(), -1 ));
		request.setOldD2Day(sayUtils.getCusomYear(request.getD2Day(), -1 ));
		request.setOldD1Day(sayUtils.getCusomYear(request.getD1Day(), -1 ));
		
		List<WeekTimeSaleNewsModel> result = weekTimeSaleNewsMapper.selectWeekTimeSaleNewsList(request);
		
	
		
		return result;
		
	}
	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<WeekTimeSaleNewsOrgModel> selectWeekTimeSaleNewsOrgList(WeekTimeSaleNewsParamModel request) throws Exception {
		
	
		//조회시작일 전년일자  생성
		request.setOldStartDate(sayUtils.getCusomYear(request.getStartDate(), -1 ));
		
		List<WeekTimeSaleNewsOrgModel> result = weekTimeSaleNewsMapper.selectWeekTimeSaleNewsOrgList(request);
		
	
		
		return result;
		
	}


}