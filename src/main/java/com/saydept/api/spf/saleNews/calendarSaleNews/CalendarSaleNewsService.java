package com.saydept.api.spf.saleNews.calendarSaleNews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.calendarSaleNews.model.CalendarSaleNewsModel;
import com.saydept.api.spf.saleNews.calendarSaleNews.model.CalendarSaleNewsParamModel;

	@Service
	public class CalendarSaleNewsService {

	@Autowired
	private CalendarSaleNewsMapper CalendarSaleNewsMapper;


	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<CalendarSaleNewsModel> selectCalendarSaleNewsList(CalendarSaleNewsParamModel request)throws Exception {

		List<CalendarSaleNewsModel> result = CalendarSaleNewsMapper.selectCalendarSaleNewsList(request);
		return result;

	}

}