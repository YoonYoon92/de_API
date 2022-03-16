package com.saydept.api.spf.saleNews.weekTimeSaleNews;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsOrgModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;

@Mapper
public interface WeekTimeSaleNewsMapper {

	WeekTimeSaleNewsParamModel selectWeekTimeSaleNews(WeekTimeSaleNewsParamModel request);

	List<WeekTimeSaleNewsModel> selectWeekTimeSaleNewsList(WeekTimeSaleNewsParamModel request);

	List<WeekTimeSaleNewsOrgModel> selectWeekTimeSaleNewsOrgList(WeekTimeSaleNewsParamModel request);


}