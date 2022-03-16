package com.saydept.api.spf.saleNews.lastYearCntstWeekSaleNews;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.lastYearCntstWeekSaleNews.model.LastYearCntstWeekSaleNewsModel;
import com.saydept.api.spf.saleNews.lastYearCntstWeekSaleNews.model.LastYearCntstWeekSaleNewsParamModel;

@Mapper
public interface LastYearCntstWeekSaleNewsMapper {

	LastYearCntstWeekSaleNewsParamModel selectLastYearCntstWeekSaleNews(LastYearCntstWeekSaleNewsParamModel request);

	List<LastYearCntstWeekSaleNewsModel> selectLastYearCntstWeekSaleNewsList(LastYearCntstWeekSaleNewsParamModel request);

	}