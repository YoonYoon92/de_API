package com.saydept.api.spf.saleNews.calendarSaleNews;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.calendarSaleNews.model.CalendarSaleNewsModel;
import com.saydept.api.spf.saleNews.calendarSaleNews.model.CalendarSaleNewsParamModel;

@Mapper
public interface CalendarSaleNewsMapper {

	List<CalendarSaleNewsModel> selectCalendarSaleNewsList(CalendarSaleNewsParamModel request);

}